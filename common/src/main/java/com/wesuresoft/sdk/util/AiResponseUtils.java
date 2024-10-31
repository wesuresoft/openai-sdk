package com.wesuresoft.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.wesuresoft.sdk.error.AiError;
import com.wesuresoft.sdk.error.AiErrorException;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zbq
 * @since 1.0.0
 */
public class AiResponseUtils {

    private static final Gson GSON;

    static {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        GSON = new GsonBuilder()
                .setDateFormat(pattern)
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (src, typeOfSrc, context) ->
                        LocalDateTime.parse(src.getAsString(), DateTimeFormatter.ofPattern(pattern)))
                .create();
    }

    public static <T> T resultHandler(String responseContent, Class<T> clazz) {
        return GSON.fromJson(responseContent, clazz);
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
