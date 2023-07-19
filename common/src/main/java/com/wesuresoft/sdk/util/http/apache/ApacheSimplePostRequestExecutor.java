package com.wesuresoft.sdk.util.http.apache;

import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.AiResponseUtils;
import com.wesuresoft.sdk.util.http.RequestHttp;
import com.wesuresoft.sdk.util.http.SimplePostRequestExecutor;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.util.Objects;

/**
 * .
 *
 * @author ecoolper
 * created on  2017/5/4
 */
public class ApacheSimplePostRequestExecutor extends SimplePostRequestExecutor<CloseableHttpClient, HttpHost> {
    public ApacheSimplePostRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public String execute(String uri, String postEntity, Header[] headers) throws AiErrorException, IOException {
        HttpPost httpPost = new HttpPost(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpPost.setConfig(config);
        }

        if (postEntity != null) {
            StringEntity entity = new StringEntity(postEntity, Consts.UTF_8);
            entity.setContentType("application/json; charset=utf-8");
            httpPost.setEntity(entity);
        }
        if (Objects.nonNull(headers)) {
            httpPost.setHeaders(headers);
        }

        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            return AiResponseUtils.handleResponse(responseContent);

        } finally {
            httpPost.releaseConnection();
        }
    }

}
