package com.wesuresoft.sdk.util.http;

import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.http.apache.OcrApacheHttpRequestExecutor;
import com.wesuresoft.sdk.bean.OcrInfo;
import org.apache.http.Header;

import java.io.IOException;

/**
 * @author zbq
 * @since 1.0.0
 */
@SuppressWarnings("all")
public abstract class OcrRequestExecutor<H, P> implements RequestExecutor<String, OcrInfo> {
    protected RequestHttp<H, P> requestHttp;

    public OcrRequestExecutor(RequestHttp<H, P> requestHttp) {
        this.requestHttp = requestHttp;
    }

    @Override
    public void execute(String uri, OcrInfo ocrInfo, Header[] headers, ResponseHandler<String> handler) throws AiErrorException, IOException {
        handler.handle(this.execute(uri, ocrInfo, headers));
    }

    public static RequestExecutor<String, OcrInfo> create(RequestHttp requestHttp) {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new OcrApacheHttpRequestExecutor(requestHttp);
            default:
                throw new IllegalArgumentException("非法请求参数");
        }
    }
}
