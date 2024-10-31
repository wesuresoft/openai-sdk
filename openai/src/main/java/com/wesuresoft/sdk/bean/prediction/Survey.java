package com.wesuresoft.sdk.bean.prediction;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Survey extends AiBaseResult<Survey.Item> {

    @Data
    public static class Item {

        /**
         * 问卷编号
         */
        private String surveyNo;

        /**
         * 问题列表
         */
        private List<SurveySubject> subjectList;
    }

    @Data
    public static class SurveySubject {
        /**
         * 问题id
         */
        private Long id;

        /**
         * 问题
         */
        private String title;

        /**
         * 问题描述
         */
        private String description;

        /**
         * 问题标签
         */
        private String label;

        /**
         * 问题选项
         */
        private String options;

        /**
         * 问题选项类型
         */
        private String optionType;

        /**
         * 排序号
         */
        private Integer sortNum;

        /**
         * 问题选项列表
         */
        private List<Option> optionList;

        /**
         * 问题唯一标识
         */
        private Integer baseId;


    }

    @Data
    public static class Option {

        /**
         * 选项ID
         */
        private Long optionId;

        /**
         * 选项
         */
        private String optionTitle;

        /**
         * 选项分数
         */
        private Integer optionScore;

        /**
         * 排序号
         */
        private Integer sortNum;
    }
}
