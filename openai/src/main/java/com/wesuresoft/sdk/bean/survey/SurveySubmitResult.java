package com.wesuresoft.sdk.bean.survey;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveySubmitResult extends AiBaseResult<SurveySubmitResult.ResultInfo> {

    @Data
    public static class ResultInfo {

        /**
         * 问卷结果
         */
        private Integer surveyResult;

        /**
         * 预测概率
         */
        private Integer predictProbability;

        /**
         * 综合结果
         */
        private Integer result;

        /**
         * 问卷分数详情
         */
        private ScoreInfo surveyScore;
    }

    @Data
    public static class ScoreInfo {

        /**
         * 分数
         */
        private Integer total;

        /**
         * 平均分
         */
        private String labelAvgScore;

        /**
         * 标签详情
         */
        private List<LabelInfo> labels;
    }

    @NoArgsConstructor
    @Data
    public static class LabelInfo {

        /**
         * 标签
         */
        private String label;

        /**
         * 分数
         */
        private Integer score;

        /**
         * 题目总数
         */
        private Integer total;

        /**
         * 平均分
         */
        private String avg;
    }
}
