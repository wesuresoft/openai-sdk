package com.wesuresoft.sdk.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiHostConfig {
    public static final String OPEN_DEFAULT_HOST_URL = "https://openai.wesuresoft.com/api";

    private String openHost;

    public static String buildUrl(AiHostConfig hostConfig, String prefix, String path) {
        if (hostConfig == null) {
            return prefix + path;
        }

        if (hostConfig.getOpenHost() != null && prefix.equals(OPEN_DEFAULT_HOST_URL)) {
            return hostConfig.getOpenHost() + path;
        }

        return prefix + path;
    }
}
