package com.wesuresoft.sdk.api;

import org.junit.jupiter.api.BeforeAll;

/**
 * @author zbq
 * @since 2.0.0
 */
class OcrServiceTest {
    private static OcrService ocrService;

    @BeforeAll
    public static void init() {
        ocrService = TestContext.init().getOcrService();
    }
}