package com.wesuresoft.sdk.util.http;

/**
 * @author ecoolper
 */
public interface RequestHttp<H, P> {

    /**
     * 返回httpClient.
     *
     * @return 返回httpClient
     */
    H getRequestHttpClient();

    /**
     * 返回httpProxy.
     * 暂未实现
     *
     * @return 返回httpProxy
     */
    P getRequestHttpProxy();

    /**
     * 返回HttpType.
     *
     * @return HttpType
     */
    HttpType getRequestType();
}