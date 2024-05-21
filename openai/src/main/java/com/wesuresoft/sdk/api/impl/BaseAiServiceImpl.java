package com.wesuresoft.sdk.api.impl;

import com.google.gson.Gson;
import com.wesuresoft.sdk.api.*;
import com.wesuresoft.sdk.bean.SignHeader;
import com.wesuresoft.sdk.config.AiConfig;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.error.AiRuntimeException;
import com.wesuresoft.sdk.util.AiConfigHolder;
import com.wesuresoft.sdk.util.Md5Util;
import com.wesuresoft.sdk.util.http.RequestExecutor;
import com.wesuresoft.sdk.util.http.RequestHttp;
import com.wesuresoft.sdk.util.http.SimpleGetRequestExecutor;
import com.wesuresoft.sdk.util.http.SimplePostRequestExecutor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zbq
 * @since 1.0.0
 */
@Slf4j
public abstract class BaseAiServiceImpl<H, P> implements OpenAiService, RequestHttp<H, P> {
    @Getter
    @Setter
    private AiService aiService = new AiServiceImpl(this);
    @Getter
    @Setter
    private DiseaseService diseaseService = new DiseaseServiceImpl(this);
    @Getter
    @Setter
    private OcrService ocrService = new OcrServiceImpl(this);
    @Getter
    @Setter
    private SurveyService surveyService = new SurveyServiceImpl(this);
    @Getter
    @Setter
    private UserService userService = new UserServiceImpl(this);

    private Map<String, AiConfig> configMap = new HashMap<>();

    private int retrySleepMillis = 1000;
    private int maxRetryTimes = 5;


    @Override
    public String get(AiApiUrl url, String queryParam) throws AiErrorException {
        return this.get(url.getUrl(getAiConfig()), queryParam);
    }

    @Override
    public String post(AiApiUrl url, String postData) throws AiErrorException {
        return this.post(url.getUrl(getAiConfig()), postData);
    }

    @Override
    public String get(String url, String queryParam) throws AiErrorException {
        return execute(SimpleGetRequestExecutor.create(this), url, queryParam);
    }

    @Override
    public String post(String url, String postData) throws AiErrorException {
        return execute(SimplePostRequestExecutor.create(this), url, postData);
    }

    @Override
    public RequestHttp<H, P> getRequestHttp() {
        return this;
    }

    @Override
    public SignHeader getSignHeader(String version) {
        long timestamp = System.currentTimeMillis();
        return getSignHeader(timestamp, version);
    }

    @Override
    public SignHeader getSignHeader(long timestamp, String version) {
        String appKey = getAiConfig().getAppKey();
        if (StringUtils.isEmpty(appKey)) {
            throw new AiRuntimeException("appKey不能为空");
        }
        String appSecret = getAiConfig().getAppSecret();
        if (StringUtils.isEmpty(appSecret)) {
            throw new AiRuntimeException("appSecret不能为空");
        }
        String ver = StringUtils.isEmpty(version) ? getAiConfig().getVersion() : version;
        String auth = appKey + ":" + Md5Util.md5Hex(ver + timestamp + appSecret);
        return SignHeader.builder()
                .authorization(auth)
                .version(ver)
                .timestamp(String.valueOf(timestamp))
                .build();
    }

    @Override
    public void setAiConfig(AiConfig aiConfig) {
        final String appKey = aiConfig.getAppKey();
        HashMap<String, AiConfig> map = new HashMap<>();
        map.put(appKey, aiConfig);
        this.setMultiConfigs(map, appKey);
    }

    @Override
    public void setMultiConfigs(Map<String, AiConfig> configs, String defaultAppKey) {
        if (this.configMap != null) {
            this.configMap.putAll(configs);
        } else {
            this.configMap = new HashMap<>(configs);
        }
        AiConfigHolder.set(defaultAppKey);
        this.initHttp();
    }

    @Override
    public void addConfig(String appKey, AiConfig aiConfig) {
        synchronized (this) {
            if (this.configMap == null || this.configMap.isEmpty()) {
                this.setAiConfig(aiConfig);
            } else {
                AiConfigHolder.set(appKey);
                this.configMap.put(appKey, aiConfig);
            }
        }
    }

    @Override
    public void removeConfig(String appKey) {
        synchronized (this) {
            if (this.configMap.size() == 1) {
                this.configMap.remove(appKey);
                log.warn("已删除最后一个OpenAI配置：{}，须立即使用setAiConfig或setMultiConfigs添加配置", appKey);
                return;
            }
            if (AiConfigHolder.get().equals(appKey)) {
                this.configMap.remove(appKey);
                final String defaultAppKey = this.configMap.keySet().iterator().next();
                AiConfigHolder.set(defaultAppKey);
                log.warn("已删除默认OpenAI配置，OpenAI【{}】被设为默认配置", appKey);
                return;
            }
            this.configMap.remove(appKey);
        }
    }

    @Override
    public AiConfig getAiConfig() {
        if (this.configMap.size() == 1) {
            return this.configMap.values().iterator().next();
        }

        return this.configMap.get(AiConfigHolder.get());
    }

    @Override
    public OpenAiService switchoverTo(String appKey) {
        if (this.configMap.containsKey(appKey)) {
            AiConfigHolder.set(appKey);
            return this;
        }

        throw new AiRuntimeException(String.format("无法找到对应【%s】的openAI配置信息，请核实！", appKey));
    }

    @Override
    @SuppressWarnings("all")
    public <T, E> T execute(RequestExecutor<T, E> executor, String uri, E data) throws AiErrorException {
        SignHeader signHeader = getSignHeader();
        int retryTimes = 0;
        do {
            try {
                return this.executeInternal(executor, uri, data, signHeader.toHeaders());
            } catch (AiErrorException e) {
                // 500 系统错误, 1000ms后重试
                if (Objects.isNull(e.getCode()) || (e.getCode() == 500 || e.getCode() == 1)) {
                    if (StringUtils.isNotEmpty(e.getMessage()) && e.getMessage().contains("检验项目")) {
                        throw e;
                    }

                    // 判断是否已经超了最大重试次数
                    if (retryTimes + 1 > this.maxRetryTimes) {
                        log.warn("重试达到最大次数【{}】", maxRetryTimes);
                        log.error("请求异常", e);
                        //最后一次重试失败后，直接抛出异常，不再等待
                        throw e;
                    }

                    int sleepMillis = this.retrySleepMillis * (1 << retryTimes);
                    try {
                        log.warn("openAI系统错误，{} ms 后重试(第{}次)", sleepMillis, retryTimes + 1);
                        Thread.sleep(sleepMillis);
                    } catch (InterruptedException e1) {
                        throw new AiErrorException(e1);
                    }
                } else {
                    throw e;
                }
            }
        } while (retryTimes++ < this.maxRetryTimes);

        log.warn("重试达到最大次数【{}】", this.maxRetryTimes);
        throw new AiErrorException("openAI服务端异常，超出重试次数");
    }

    protected <T, E> T executeInternal(RequestExecutor<T, E> executor, String uri, E data, Header[] headers) throws AiErrorException {
        try {
            T result = executor.execute(uri, data, headers);
            if (log.isDebugEnabled()) {
                log.debug("\n【请求地址】: {}\n【请求参数】：{}\n【响应数据】：{}", uri, new Gson().toJson(data), result);
            }
            return result;
        } catch (AiErrorException e) {
            log.warn("\n【请求地址】: {}\n【请求参数】：{}\n【错误信息】：", uri, new Gson().toJson(data), e);
            throw e;
        } catch (IOException e) {
            log.warn("\n【请求地址】: {}\n【请求参数】：{}\n【异常信息】：{}", uri, new Gson().toJson(data), e.getMessage());
            throw new AiErrorException(e);
        }
    }
}
