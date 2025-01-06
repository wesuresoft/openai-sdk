package com.wesuresoft.sdk.bean.prediction.ir;

import com.wesuresoft.sdk.bean.prediction.IRBaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.3
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IRHzbLiaoParam extends IRBaseParam {
    private RiskOverviewDTO riskOverview;

    @Data
    public static class RiskOverviewDTO {
        private String name;
        private Float predict;
        private Integer riskLevel;
        private String introduction;
        /**
         * @since 2.0.4
         */
        private Boolean hasAbnormal;
        private List<DateRiskDTO> historyList;
    }

    @Data
    public static class DateRiskDTO {
        /**
         * yyyy-MM-dd
         */
        private String date;
        private Float risk;
        /**
         * @since 2.0.4
         */
        private Integer riskLevel;
    }
}
