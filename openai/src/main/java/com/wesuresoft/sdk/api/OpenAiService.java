package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.SignHeader;
import com.wesuresoft.sdk.config.AiConfig;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.http.RequestExecutor;
import com.wesuresoft.sdk.util.http.RequestHttp;

import java.util.Map;

/**
 * @author zbq
 * @since 1.0.0
 */
public interface OpenAiService extends com.wesuresoft.sdk.service.AiService {

    /**
     * 返回ai类功能实现类
     */
    AiService getAiService();

    /**
     * 返回疾病类功能实现类
     */
    DiseaseService getDiseaseService();

    /**
     * 返回图像识别类功能实现类
     */
    OcrService getOcrService();

    /**
     * 返回问卷类功能实现类
     */
    SurveyService getSurveyService();

    /**
     * 返回用户类功能实现类
     */
    UserService getUserService();

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

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有的GET请求.
     *
     * @param url        请求接口地址
     * @param queryParam 参数
     * @return 接口响应字符串 string
     * @throws AiErrorException 异常
     */
    String get(AiApiUrl url, String queryParam) throws AiErrorException;

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有的POST请求.
     *
     * @param url      请求接口地址
     * @param postData 请求参数json值
     * @return 接口响应字符串 string
     * @throws AiErrorException 异常
     */
    String post(AiApiUrl url, String postData) throws AiErrorException;

    /**
     * 向开放平台发送请求
     */
    <T, E> T execute(RequestExecutor<T, E> executor, String uri, E data) throws AiErrorException;
}
