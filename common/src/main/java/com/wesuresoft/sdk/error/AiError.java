package com.wesuresoft.sdk.error;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiError implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 错误代码.
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    private String json;

    public AiError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static AiError fromJson(String json) {
        AiError aiError = new Gson().fromJson(json, AiError.class);
        aiError.setJson(json);
        return aiError;
    }

    @Override
    public String toString() {
        if (this.json == null) {
            return "错误代码：" + this.code + ", 错误信息：" + this.msg;
        }

        return "错误代码：" + this.code + ", 错误信息：" + this.msg + "，原始报文：" + this.json;
    }

}
