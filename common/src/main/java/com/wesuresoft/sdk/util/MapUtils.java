package com.wesuresoft.sdk.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;

/**
 * @author zbq
 * @since 1.0.0
 */
public class MapUtils {

    public static <K, V> void putNonNullValue(Map<K, V> map, K key, V value) {
        if (value instanceof String) {
            if (StringUtils.isNotBlank((String) value)) {
                map.put(key, value);
            }
        } else if (Objects.nonNull(value)) {
            map.put(key, value);
        }
    }

    public static <K, V> void putNonNullValue(Map<K, V> map, K key, V value, V defaultValue) {
        if (value instanceof String) {
            if (StringUtils.isNotBlank((String) value)) {
                map.put(key, value);
            } else {
                map.put(key, defaultValue);
            }
        } else if (Objects.nonNull(value)) {
            map.put(key, value);
        } else {
            map.put(key, defaultValue);
        }
    }

    public static <K, V> String toJsonStr(Map<K, V> map) {
        return new Gson().toJson(map);
    }
}
