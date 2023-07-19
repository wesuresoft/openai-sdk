package com.wesuresoft.sdk.service;

import com.wesuresoft.sdk.error.AiErrorException;

/**
 * @author zbq
 * @since 1.0.0
 */
public interface AiService {
    /**
     * 当本Service没有实现某个API的时候，可以用这个
     *
     * @param queryParam 参数
     * @param url        请求接口地址
     * @return 接口响应字符串
     * @throws AiErrorException 异常
     */
    String get(String url, String queryParam) throws AiErrorException;

    /**
     * 当本Service没有实现某个API的时候，可以用这个
     *
     * @param postData 请求参数json值
     * @param url      请求接口地址
     * @return 接口响应字符串
     * @throws AiErrorException 异常
     */
    String post(String url, String postData) throws AiErrorException;
}
