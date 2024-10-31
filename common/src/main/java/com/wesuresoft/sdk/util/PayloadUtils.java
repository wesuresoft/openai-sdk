package com.wesuresoft.sdk.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author zbq
 * @since 2.0.0
 */
@Slf4j
public class PayloadUtils {

    private final static Gson GSON = new GsonBuilder().serializeNulls().create();

    public static String toJsonStr(Object obj) {
        return GSON.toJson(obj);
    }

    public static String buildParam(String key, Object value) {
        return build(key, value);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2) {
        return build(key1, value1, key2, value2);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
        return build(key1, value1, key2, value2, key3, value3);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3,
                                    String key4, Object value4) {
        return build(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3,
                                    String key4, Object value4, String key5, Object value5) {
        return build(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3,
                                    String key4, Object value4, String key5, Object value5, String key6, Object value6) {
        return build(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3,
                                    String key4, Object value4, String key5, Object value5, String key6, Object value6,
                                    String key7, Object value7) {
        return build(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3,
                                    String key4, Object value4, String key5, Object value5, String key6, Object value6,
                                    String key7, Object value7, String key8, Object value8) {
        return build(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7,
                key8, value8);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3,
                                    String key4, Object value4, String key5, Object value5, String key6, Object value6,
                                    String key7, Object value7, String key8, Object value8, String key9, Object value9) {
        return build(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7,
                key8, value8, key9, value9);
    }

    public static String buildParam(String key1, Object value1, String key2, Object value2, String key3, Object value3,
                                    String key4, Object value4, String key5, Object value5, String key6, Object value6,
                                    String key7, Object value7, String key8, Object value8, String key9, Object value9,
                                    String key10, Object value10) {
        return build(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7, value7,
                key8, value8, key9, value9, key10, value10);
    }

    private static String build(Object... v) {
        StringBuilder param = new StringBuilder();
        for (int i = 0; i < v.length; i = i + 2) {
            String key = (String) v[i];
            Object value = v[i + 1];
            if (Objects.nonNull(value)) {
                param.append("&").append(key).append("=").append(value);
            }
        }

        return param.length() > 1 ? param.substring(1) : null;
    }
}
