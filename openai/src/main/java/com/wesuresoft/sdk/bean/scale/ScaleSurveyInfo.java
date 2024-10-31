package com.wesuresoft.sdk.bean.scale;

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
public class ScaleSurveyInfo extends AiBaseResult<List<ScaleSurveyInfo.Item>> {

    @Data
    public static class Item {
        /**
         * 主键
         */
        private Integer id;

        /**
         * 问卷标题
         */
        private String title;

        /**
         * 问卷描述
         */
        private String description;

        /**
         * 题目总数
         */
        private Integer subjectCount;

        /**
         * 问卷类型(TCM,SF12等)
         */
        private String type;
    }
}
