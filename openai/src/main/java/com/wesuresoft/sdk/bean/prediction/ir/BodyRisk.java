package com.wesuresoft.sdk.bean.prediction.ir;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.3
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BodyRisk {
    private Count count;
    private List<Info> infos;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Info {
        private String organ;
        private Integer riskLevel;
        private String diseaseNames;
        private String definition;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Count {
        private Integer total;
        private Integer high;
        private Integer low;
    }
}
