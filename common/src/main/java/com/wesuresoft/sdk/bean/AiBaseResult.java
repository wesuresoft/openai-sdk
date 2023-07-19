package com.wesuresoft.sdk.bean;

import lombok.Data;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
public class AiBaseResult<T> {
    /**
     * 请求id
     */
    private String requestId;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应码含义
     */
    private String msg;

    /**
     * 结果
     */
    private T data;

    /**
     * 请求用时
     */
    private Long time;
}
