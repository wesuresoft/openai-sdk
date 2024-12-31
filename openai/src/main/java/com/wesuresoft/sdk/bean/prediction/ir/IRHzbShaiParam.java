package com.wesuresoft.sdk.bean.prediction.ir;

import com.wesuresoft.sdk.bean.prediction.IRBaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * @author zbq
 * @since 2.0.3
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IRHzbShaiParam extends IRBaseParam {
    private Map<String, Integer> humanSystem;
    private BodyRisk bodyRisk;
    private List<RangeDTO> allDisease;
    private List<SurveyInfo> surveyList;


    @Data
    public static class RangeDTO {
        private String organ;
        private String diseaseNames;
    }
}
