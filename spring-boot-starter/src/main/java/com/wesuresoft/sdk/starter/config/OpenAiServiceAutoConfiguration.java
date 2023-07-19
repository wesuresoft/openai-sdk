package com.wesuresoft.sdk.starter.config;

import com.wesuresoft.sdk.starter.properties.OpenAiProperties;
import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.api.impl.OpenAiServiceHttpClientImpl;
import com.wesuresoft.sdk.config.AiConfig;
import com.wesuresoft.sdk.config.AiHostConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zbq
 * @since 1.0.0
 */
@Configuration
@RequiredArgsConstructor
public class OpenAiServiceAutoConfiguration {
    private final OpenAiProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public OpenAiService openAiService() {
        AiConfig config = new AiConfig();
        config.setAppKey(properties.getAppKey());
        config.setAppSecret(properties.getAppSecret());
        config.setVersion(properties.getVersion());
        AiHostConfig hostConfig = new AiHostConfig();
        hostConfig.setOpenHost(properties.getOpenHost());
        config.setHostConfig(hostConfig);

        OpenAiService openAiService = new OpenAiServiceHttpClientImpl();
        openAiService.setAiConfig(config);
        return openAiService;
    }
}
