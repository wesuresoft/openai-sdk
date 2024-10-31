package com.wesuresoft.sdk.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author zbq
 * @since 2.0.0
 */
class OpenAiServiceTest {
    private static OpenAiService openAiService;

    @BeforeAll
    public static void init() {
        openAiService = TestContext.init();
    }

    @Test
    void getDictService() {
        Assertions.assertNotNull(openAiService.getDictService());
    }

    @Test
    void getPredictionService() {
        Assertions.assertNotNull(openAiService.getPredictionService());
    }

    @Test
    void getScaleService() {
        Assertions.assertNotNull(openAiService.getScaleService());
    }

    @Test
    void getOcrService() {
        Assertions.assertNotNull(openAiService.getOcrService());
    }
}