package com.wesuresoft.sdk.bean.prediction;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zbq
 * @since 2.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RecordDisease extends AiBaseResult<RecordDisease.Item> {

    @Data
    public static class Item {
        /**
         * 识别记录编码
         */
        private String recordNo;

        /**
         * 识别时间
         */
        private LocalDateTime recordTime;

        /**
         * 识别结果
         */
        private List<DiseaseResult> diseaseResults;
    }


    @Data
    public static class DiseaseResult {

        /**
         * 疾病编码
         */
        private Integer diseaseCode;

        /**
         * 疾病名称
         */
        private String diseaseName;

        /**
         * 疾病包编码
         */
        private Integer packageCode;

        /**
         * 父疾病code
         */
        private Integer diseaseParent;

        /**
         * 风险值
         */
        private Float predict;

        /**
         * 严重程度
         */
        private Float severity;

        /**
         * 风险等级
         */
        private Integer riskLevel;

        /**
         * 识别信息备注
         */
        private String remark;
    }
}
