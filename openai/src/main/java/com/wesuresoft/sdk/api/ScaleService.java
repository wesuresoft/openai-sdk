package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.scale.*;

/**
 * @author zbq
 * @since 2.0.0
 */
public interface ScaleService {

    default ScaleSurveyInfo getScaleList() {
        return getScaleList(null);
    }

    /**
     * 获取量表列表
     * type: SF12
     */
    ScaleSurveyInfo getScaleList(String type);

    SurveySubject getScaleSubject(Integer surveyId);

    /**
     * 获取量表相关说明信息
     */
    ScaleInfo getScaleInfo(String type);

    /**
     * 提交量表问卷
     */
    ScaleSubject submitScaleSubject(ScaleSurveySubmitParam param);

    /**
     * 查看量表问题
     */
    SurveySubject getSubmitScaleSubject(String recordNo, Integer surveyId);

    /**
     * 查看量表结论
     */
    ScaleSurvey getScaleView(String recordNo, Integer surveyId);

    ScaleSurvey getScaleView(String recordNo, Integer surveyId, String dir);

    /**
     * 查询检测包可用的量表id
     */
    ScaleSurveyId getScaleSurveyId(Integer packageCode);
}
