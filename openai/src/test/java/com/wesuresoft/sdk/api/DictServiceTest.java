package com.wesuresoft.sdk.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author zbq
 * @since 2.0.0
 */
class DictServiceTest {

    private static DictService dictService;

    @BeforeAll
    public static void init() {
        dictService = TestContext.init().getDictService();
    }

    @Test
    void standardItem_WithoutTestType_ReturnsNonNull() {
        assertNotNull(dictService.standardItem());
    }

    @Test
    void standardItem_WithTestType_ReturnsNonNull() {
        assertNotNull(dictService.standardItem(2));
    }

    @Test
    void disease_WithoutDiseaseCode_ReturnsNonNull() {
        assertNotNull(dictService.disease());
    }

    @Test
    void disease_WithDiseaseCode_ReturnsNonNull() {
        assertNotNull(dictService.disease(30001));
    }

    @Test
    void packages_WithoutPackageCode_ReturnsNonNull() {
        assertNotNull(dictService.packages());
    }

    @Test
    void packages_WithPackageCode_ReturnsNonNull() {
        assertNotNull(dictService.packages(168));
    }

    @Test
    void packageItems_ReturnsNonNull() {
        assertNotNull(dictService.packageItems(168));
    }

    @Test
    void packagePrecondition_ReturnsNonNull() {
        assertNotNull(dictService.packagePrecondition(168));
    }
}