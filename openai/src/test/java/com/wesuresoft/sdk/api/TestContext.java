package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.api.impl.OpenAiServiceHttpClientImpl;
import com.wesuresoft.sdk.config.AiConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * @author zbq
 * @since 2.0.0
 */
public class TestContext {

    public static OpenAiService init() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = TestContext.class.getClassLoader().getResourceAsStream("config.key");
            if (Objects.nonNull(inputStream)) {
                properties.load(inputStream);
                String key = properties.getProperty("app.key");
                String secret = properties.getProperty("app.secret");
                inputStream.close();
                AiConfig aiConfig = new AiConfig();
                aiConfig.setAppKey(key);
                aiConfig.setAppSecret(secret);
                OpenAiService openAiService = new OpenAiServiceHttpClientImpl();
                openAiService.setAiConfig(aiConfig);
                return openAiService;
            }
        } catch (IOException e) {
            // ignore
        }
        throw new RuntimeException("配置文件 config.key 未找到!");
    }
}
