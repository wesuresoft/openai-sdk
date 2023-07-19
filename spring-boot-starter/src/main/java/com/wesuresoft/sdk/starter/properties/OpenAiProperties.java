package com.wesuresoft.sdk.starter.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(OpenAiProperties.PREFIX)
public class OpenAiProperties {
    public static final String PREFIX = "openai";

    /**
     * App_Key
     */
    private String appKey;
    /**
     * App_Secret
     */
    private String appSecret;
    /**
     * 版本号
     */
    private String version = "v1";

    /**
     * 域名配置
     */
    private String openHost;

}
