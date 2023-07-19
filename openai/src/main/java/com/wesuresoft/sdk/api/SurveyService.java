package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.survey.SubmitSurveyInfo;
import com.wesuresoft.sdk.bean.survey.SurveyResult;
import com.wesuresoft.sdk.bean.survey.SurveySubmitResult;
import com.wesuresoft.sdk.error.AiErrorException;

/**
 * @author zbq
 * @since 1.0.6
 */
public interface SurveyService {
    /**
     * 获取疾病问卷
     *
     * @param diseaseCode 疾病编码
     */
    default SurveyResult survey(Integer diseaseCode) throws AiErrorException {
        return survey(diseaseCode, null);
    }

    /**
     * 获取疾病问卷
     *
     * @param diseaseCode 疾病编码
     * @param surveyType  问卷类型
     */
    SurveyResult survey(Integer diseaseCode, Integer surveyType) throws AiErrorException;

    /**
     * @param info 问卷提交参数
     */
    SurveySubmitResult surveySubmit(SubmitSurveyInfo info) throws AiErrorException;
}
