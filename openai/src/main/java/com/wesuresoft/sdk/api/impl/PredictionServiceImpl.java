package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.api.PredictionService;
import com.wesuresoft.sdk.bean.prediction.*;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.util.AiResponseUtils;
import lombok.RequiredArgsConstructor;

import static com.wesuresoft.sdk.util.PayloadUtils.buildParam;
import static com.wesuresoft.sdk.util.PayloadUtils.toJsonStr;

/**
 * @author zbq
 * @since 2.0.0
 */
@RequiredArgsConstructor
public class PredictionServiceImpl implements PredictionService {
    private final OpenAiService openAiService;

    @Override
    public Procedure predict(PredictionParam predictionParam) {
        String responseContent = this.openAiService.post(AiApiUrl.Prediction.PREDICT_URL, toJsonStr(predictionParam));
        return AiResponseUtils.resultHandler(responseContent, Procedure.class);
    }

    @Override
    public Survey downloadSurvey(String surveyNo) {
        String responseContent = this.openAiService.get(AiApiUrl.Prediction.SURVEY_URL, buildParam("surveyNo", surveyNo));
        return AiResponseUtils.resultHandler(responseContent, Survey.class);
    }

    @Override
    public Procedure submitSurvey(SurveyParam surveyParam) {
        String responseContent = this.openAiService.post(AiApiUrl.Prediction.SURVEY_URL, toJsonStr(surveyParam));
        return AiResponseUtils.resultHandler(responseContent, Procedure.class);
    }

    @Override
    public RecordDisease downloadResult(String recordNo) {
        String responseContent = this.openAiService.get(AiApiUrl.Prediction.PREDICT_URL, buildParam("recordNo", recordNo));
        return AiResponseUtils.resultHandler(responseContent, RecordDisease.class);
    }

    @Override
    public Survey surveyResult(String surveyNo) {
        String responseContent = this.openAiService.get(AiApiUrl.Prediction.SURVEY_RESULT_URL, buildParam("surveyNo", surveyNo));
        return AiResponseUtils.resultHandler(responseContent, Survey.class);
    }

    @Override
    public CreatePdf createPdf(CreatePdfParam param) {
        String responseContent = this.openAiService.post(AiApiUrl.Prediction.CREATE_PDF_URL, toJsonStr(param));
        return AiResponseUtils.resultHandler(responseContent, CreatePdf.class);
    }
}
