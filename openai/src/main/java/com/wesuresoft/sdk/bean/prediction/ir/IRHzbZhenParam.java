package com.wesuresoft.sdk.bean.prediction.ir;

import com.wesuresoft.sdk.bean.prediction.IRBaseParam;
import lombok.*;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.3
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IRHzbZhenParam extends IRBaseParam {
    private List<String> noRisk;
    private List<String> hasRisk;
    private List<DiseaseInfo> diseaseList;
    private List<SurveyInfo> surveyList;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DiseaseInfo {
        private String diseaseName;
        private String description;
    }
}
