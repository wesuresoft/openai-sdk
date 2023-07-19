package com.wesuresoft.sdk.util.http;

import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.http.apache.ApacheSimpleGetRequestExecutor;
import org.apache.http.Header;

import java.io.IOException;

/**
 * 简单的GET请求执行器.
 * 请求的参数是String, 返回的结果也是String
 *
 * @author Daniel Qian
 */
public abstract class SimpleGetRequestExecutor<H, P> implements RequestExecutor<String, String> {
    protected RequestHttp<H, P> requestHttp;

    public SimpleGetRequestExecutor(RequestHttp<H, P> requestHttp) {
        this.requestHttp = requestHttp;
    }

    @Override
    public void execute(String uri, String data, Header[] headers, ResponseHandler<String> handler) throws AiErrorException, IOException {
        handler.handle(this.execute(uri, data, headers));
    }

    public static RequestExecutor<String, String> create(RequestHttp<?, ?> requestHttp) {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new ApacheSimpleGetRequestExecutor(requestHttp);
            default:
                throw new IllegalArgumentException("非法请求参数");
        }
    }
}
