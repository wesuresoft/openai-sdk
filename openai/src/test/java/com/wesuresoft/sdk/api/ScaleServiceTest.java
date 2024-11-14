package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.scale.ScaleSurveySubmitParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author zbq
 * @since 2.0.0
 */
class ScaleServiceTest {
    private static ScaleService scaleService;

    @BeforeAll
    public static void init() {
        scaleService = TestContext.init().getScaleService();
    }


    @Test
    void getScaleList() {
        Assertions.assertNotNull(scaleService.getScaleList());
    }

    @Test
    void testGetScaleList() {
        Assertions.assertNotNull(scaleService.getScaleList("SF12"));
    }

    @Test
    void getScaleSubject() {
        Assertions.assertNotNull(scaleService.getScaleSubject(3));
    }

    @Test
    void getScaleInfo() {
        Assertions.assertNotNull(scaleService.getScaleInfo("SF12"));
    }

    @Test
    void submitScaleSubject() {
        ScaleSurveySubmitParam param = new ScaleSurveySubmitParam();
        param.setSurveyId(1);
        param.setRecordNo("TCM33TEST");
        param.setOptions("2,7,14,17,22,30,34,37,41,48,51,57,61,69,74,76,82,87,93,99,104,108,115,119,123,128,133,136,142,149,152,159,164");
        param.setResults(new Integer[]{2, 2, 4, 2, 2, 5, 4, 2, 1, 3, 1, 2, 1, 4, 4, 1, 2, 2, 3, 4, 4, 3, 5, 4, 3, 3, 3, 1, 2, 4, 2, 4, 4});

        // Assertions.assertNotNull(scaleService.submitScaleSubject(param));
    }

    @Test
    void getSubmitScaleSubject() {
        Assertions.assertNotNull(scaleService.getSubmitScaleSubject("APIV2:57f50f563b50699e73ab7ef95b1fd68e", 2));
    }

    @Test
    void getScaleView() {
        Assertions.assertNotNull(scaleService.getScaleView("APIV2:57f50f563b50699e73ab7ef95b1fd68e", 2));
    }

    @Test
    void getScaleSurveyId() {
        Assertions.assertNotNull(scaleService.getScaleSurveyId(2));
    }
}