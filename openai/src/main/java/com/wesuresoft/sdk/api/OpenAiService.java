package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.SignHeader;
import com.wesuresoft.sdk.config.AiConfig;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.service.AiService;
import com.wesuresoft.sdk.util.http.RequestExecutor;
import com.wesuresoft.sdk.util.http.RequestHttp;

import java.util.Map;

/**
 * @author zbq
 * @since 1.0.0
 */
public interface OpenAiService extends AiService {

    /**
     * 返回字典实现类
     */
    DictService getDictService();

    /**
     * 返回预测实现类
     */
    PredictionService getPredictionService();

    /**
     * 返回量表实现类
     */
    ScaleService getScaleService();

    /**
     * 返回图像识别类功能实现类
     */
    OcrService getOcrService();

    /**
     * 初始化http请求对象.
     */
    void initHttp();

    /**
     * 获取RequestHttp对象.
     *
     * @return RequestHttp对象 request http
     */
    RequestHttp getRequestHttp();

    /**
     * 获取授权请求头
     *
     * @param version 版本号
     * @return SignHeader 对象
     */
    SignHeader getSignHeader(String version);

    /**
     * 获取授权请求头
     *
     * @param timestamp 时间戳
     * @return SignHeader 对象
     */
    default SignHeader getSignHeader(long timestamp) {
        return getSignHeader(timestamp, "v1");
    }

    /**
     * 获取授权请求头
     *
     * @param timestamp 时间戳
     * @param version   版本号
     * @return SignHeader 对象
     */
    SignHeader getSignHeader(long timestamp, String version);

    /**
     * 获取默认版本授权请求头
     *
     * @return SignHeader 对象
     */
    default SignHeader getSignHeader() {
        return getSignHeader("v1");
    }

    void setAiConfig(AiConfig aiConfig);

    /**
     * 注入多个配置
     */
    void setMultiConfigs(Map<String, AiConfig> configs, String defaultAppKey);

    /**
     * 添加新的配置
     */
    void addConfig(String appKey, AiConfig aiConfig);

    /**
     * 移除配置
     */
    void removeConfig(String appKey);

    /**
     * 切换openAI配置
     *
     * @param appKey
     * @return
     */
    OpenAiService switchoverTo(String appKey);

    /**
     * 获取配置
     */
    AiConfig getAiConfig();

    default String get(AiApiUrl url, String... pathVariable) throws AiErrorException {
        return get(url, null, pathVariable);
    }

    default String get(AiApiUrl url, String queryParam) throws AiErrorException {
        return get(url, queryParam, null);
    }

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有的GET请求.
     *
     * @param url          请求接口地址（参数使用%s代替）
     * @param queryParam   参数
     * @param pathVariable 参数
     * @return 接口响应字符串 string
     * @throws AiErrorException 异常
     */
    String get(AiApiUrl url, String queryParam, String... pathVariable) throws AiErrorException;

    default String post(AiApiUrl url, String... pathVariable) throws AiErrorException {
        return post(url, null, pathVariable);
    }

    default String post(AiApiUrl url, String postData) throws AiErrorException {
        return post(url, postData, null);
    }

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有的POST请求.
     *
     * @param url          请求接口地址（参数使用%s代替）
     * @param postData     请求参数json值
     * @param pathVariable 参数
     * @return 接口响应字符串 string
     * @throws AiErrorException 异常
     */
    String post(AiApiUrl url, String postData, String... pathVariable) throws AiErrorException;

    /**
     * 向开放平台发送请求
     */
    <T, E> T execute(RequestExecutor<T, E> executor, String uri, E data) throws AiErrorException;
}
