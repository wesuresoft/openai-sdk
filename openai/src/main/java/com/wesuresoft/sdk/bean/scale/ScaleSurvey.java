package com.wesuresoft.sdk.bean.scale;

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
public class ScaleSurvey extends AiBaseResult<ScaleSurvey.Item> {

    @Data
    public static class Item {
        /**
         * 识别记录标识
         */
        private String recordNo;

        /**
         * 量表id
         */
        private Integer surveyId;

        /**
         * 量表类型
         */
        private String type;

        /**
         * 填写时间
         */
        private LocalDateTime answerTime;

        /**
         * 层面
         */
        private List<Sf12Result> levels;

        /**
         * 体质辨识结果
         */
        private Integer count;

        /**
         * 体质信息列表
         */
        private List<Constitution> constitutions;
    }

    @Data
    public static class Constitution {

        /**
         * 体质名
         */
        private String name;

        /**
         * 体质代码
         */
        private String code;

        /**
         * 体质结果  1,是  2, 基本是  3,否
         */
        private Integer result;

        /**
         * 体质得分
         */
        private Integer score;

        /**
         * 体质描述
         */
        private String description;

    }


    @Data
    public static class Sf12Result {

        /**
         * 名称
         */
        private String name;

        /**
         * 编码
         */
        private String code;

        /**
         * 得分
         */
        private Float score;

        /**
         * 得分范围
         */
        private String scoreRange;

        /**
         * 描述
         */
        private String description;

        /**
         * 维度
         */
        private List<Sf12Result> sf12Results;
    }
}
