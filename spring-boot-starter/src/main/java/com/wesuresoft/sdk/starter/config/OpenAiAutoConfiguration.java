package com.wesuresoft.sdk.starter.config;

import com.wesuresoft.sdk.starter.properties.OpenAiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zbq
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(OpenAiProperties.class)
@Import({OpenAiServiceAutoConfiguration.class})
public class OpenAiAutoConfiguration {
}
