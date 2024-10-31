package com.wesuresoft.sdk.bean.scale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zbq
 * @since 2.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScaleSurveySubmitParam {
    /**
     * 量表id
     */
    private Integer surveyId;

    /**
     * 识别记录标识
     */
    private String recordNo;

    /**
     * 选项信息
     */
    private String options;

    /**
     * 得分信息
     */
    private Integer[] results;
}
