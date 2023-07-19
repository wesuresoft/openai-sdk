package com.wesuresoft.sdk.bean.ai;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PredictResult extends AiBaseResult<List<PredictResult.DiseaseInfo>> {

    @Data
    public static class DiseaseInfo {
        /**
         * 疾病编码
         */
        private Integer code;
        /**
         * 疾病名称
         */
        private String name;
        /**
         * 疾病概率
         */
        private Float probability;
        /**
         * 匹配到的模型id
         */
        private Long matchId;
        /**
         * 平台推荐的阈值
         */
        private Float defaultThreshold;
        /**
         * 问卷id
         */
        private String surveyId;
    }
}
