package com.wesuresoft.sdk.util.http.apache;

import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.http.RequestHttp;
import com.wesuresoft.sdk.util.http.SimpleGetRequestExecutor;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.util.Objects;

/**
 * .
 *
 * @author ecoolper
 * created on  2017/5/4
 */
public class HtmlApacheHttpRequestExecutor extends SimpleGetRequestExecutor<CloseableHttpClient, HttpHost> {
    public HtmlApacheHttpRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public String execute(String uri, String queryParam, Header[] headers) throws AiErrorException, IOException {
        if (Objects.nonNull(queryParam)) {
            if (uri.indexOf('?') == -1) {
                uri += '?';
            }
            uri += uri.endsWith("?") ? queryParam : '&' + queryParam;
        }
        HttpGet httpGet = new HttpGet(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpGet.setConfig(config);
        }
        if (Objects.nonNull(headers)) {
            httpGet.setHeaders(headers);
        }

        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpGet)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            if (StringUtils.isBlank(responseContent)) {
                throw new AiErrorException("无响应内容");
            }

            return responseContent;

        } finally {
            httpGet.releaseConnection();
        }
    }

}
