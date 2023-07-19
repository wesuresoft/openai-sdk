package com.wesuresoft.sdk.util.http;

import com.wesuresoft.sdk.error.AiErrorException;
import org.apache.http.Header;

import java.io.IOException;

/**
 * http请求执行器.
 *
 * @param <T> 返回值类型
 * @param <E> 请求参数类型
 * @author zbq
 * @since 1.0.0
 */
public interface RequestExecutor<T, E> {

    /**
     * 执行http请求.
     *
     * @param uri  uri
     * @param data 数据
     * @return 响应结果
     * @throws AiErrorException 自定义异常
     * @throws IOException      io异常
     */
    T execute(String uri, E data, Header[] headers) throws AiErrorException, IOException;

    /**
     * 执行http请求.
     *
     * @param uri     uri
     * @param data    数据
     * @param handler http响应处理器
     * @throws AiErrorException 自定义异常
     * @throws IOException      io异常
     */
    void execute(String uri, E data, Header[] headers, ResponseHandler<T> handler) throws AiErrorException, IOException;


}
