package com.wesuresoft.sdk.util;

import com.wesuresoft.sdk.error.AiError;
import com.wesuresoft.sdk.error.AiErrorException;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zbq
 * @since 1.0.0
 */
public class AiResponseUtils {
    public static <T> T resultHandler(String responseContent, Class<T> clazz) {
        return new Gson().fromJson(responseContent, clazz);
    }

    public static String handleResponse(String responseContent) throws AiErrorException {
        if (StringUtils.isBlank(responseContent)) {
            throw new AiErrorException("无响应内容");
        }

        AiError error = AiError.fromJson(responseContent);
        if (error.getCode() != 0) {
            throw new AiErrorException(error);
        }

        return responseContent;
    }
}
