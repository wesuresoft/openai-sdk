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
public class SurveyResult extends AiBaseResult<SurveyResult.SurveyInfo> {

    @Data
    public static class SurveyInfo {

        /**
         * 疾病编码
         */
        private Integer diseaseCode;

        /**
         * 问卷名称
         */
        private String surveyTitle;

        /**
         * 问卷id
         */
        private String surveyId;

        /**
         * 问卷描述
         */
        private String surveyDesc;

        /**
         * 问卷题目数量
         */
        private Integer subjectCount;

        /**
         * 问卷总分
         */
        private Integer totalScore;

        /**
         * 题目列表
         */
        private List<Subject> subjects;
    }

    @Data
    public static class Subject {
        /**
         * 题目 id
         */
        private String subjectId;

        /**
         * 题目名称
         */
        private String subjectTitle;

        /**
         * 题目描述
         */
        private String subjectDesc;

        /**
         * 题目标签，多个用逗号隔开
         */
        private String subjectLabel;

        /**
         * 题目类型
         */
        private String optionType;

        /**
         * 选项列表
         */
        private List<Option> options;
    }

    @NoArgsConstructor
    @Data
    public static class Option {

        /**
         * 选项 id
         */
        private String optionId;

        /**
         * 选项描述
         */
        private String optionTitle;

        /**
         * 选项得分
         */
        private String optionScore;
    }
}
