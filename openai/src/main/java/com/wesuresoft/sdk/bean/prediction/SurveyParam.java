package com.wesuresoft.sdk.bean.prediction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SurveyParam {
    /**
     * 问卷编号
     */
    private String surveyNo;

    /**
     * 结果项
     */
    private List<Item> items;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Item {

        /**
         * 问题id
         */
        private Long id;

        /**
         * 选项id
         */
        private String options;
    }
}
