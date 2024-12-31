package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.prediction.*;

/**
 * @author zbq
 * @since 2.0.0
 */
public interface PredictionService {

    /**
     * 评估接口
     */
    Procedure predict(PredictionParam predictionParam);

    /**
     * 下载问卷
     */
    Survey downloadSurvey(String surveyNo);

    /**
     * 提交问卷结果
     */
    Procedure submitSurvey(SurveyParam surveyParam);

    /**
     * 下载评估结果
     */
    RecordDisease downloadResult(String recordNo);

    /**
     * 查看问卷结果
     */
    Survey surveyResult(String surveyNo);

    /**
     * 创建pdf报告
     */
    CreatePdf createPdf(CreatePdfParam param);

    /**
     * 获取智能报告url
     *
     * @param objectName 文件名
     */
    IRResult getUrlIR(String objectName);

    /**
     * 智能报告生成
     */
    IRResult creatPdfIR(IRBaseParam param, String templateName);
}
