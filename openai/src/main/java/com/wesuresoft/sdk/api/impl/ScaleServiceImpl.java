package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.api.ScaleService;
import com.wesuresoft.sdk.bean.scale.*;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.util.AiResponseUtils;
import lombok.AllArgsConstructor;

import static com.wesuresoft.sdk.util.PayloadUtils.buildParam;
import static com.wesuresoft.sdk.util.PayloadUtils.toJsonStr;

/**
 * @author zbq
 * @since 2.0.0
 */
@AllArgsConstructor
public class ScaleServiceImpl implements ScaleService {
    private final OpenAiService openAiService;

    @Override
    public ScaleSurveyInfo getScaleList(String type) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.LIST_URL, buildParam("type", type));
        return AiResponseUtils.resultHandler(responseContent, ScaleSurveyInfo.class);
    }

    @Override
    public SurveySubject getScaleSubject(Integer surveyId) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.SURVEY_URL, buildParam("surveyId", surveyId));
        return AiResponseUtils.resultHandler(responseContent, SurveySubject.class);
    }

    @Override
    public ScaleInfo getScaleInfo(String type) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.INSTRUCTION_URL, buildParam("type", type));
        return AiResponseUtils.resultHandler(responseContent, ScaleInfo.class);
    }

    @Override
    public ScaleSubject submitScaleSubject(ScaleSurveySubmitParam param) {
        String responseContent = this.openAiService.post(AiApiUrl.Scale.SUBMIT_URL, toJsonStr(param));
        return AiResponseUtils.resultHandler(responseContent, ScaleSubject.class);
    }

    @Override
    public SurveySubject getSubmitScaleSubject(String recordNo, Integer surveyId) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.RESULT_URL,
                buildParam("recordNo", recordNo, "surveyId", surveyId));
        return AiResponseUtils.resultHandler(responseContent, SurveySubject.class);
    }

    @Override
    public ScaleSurvey getScaleView(String recordNo, Integer surveyId) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.VIEW_URL,
                buildParam("recordNo", recordNo, "surveyId", surveyId));
        return AiResponseUtils.resultHandler(responseContent, ScaleSurvey.class);
    }

    @Override
    public ScaleSurveyId getScaleSurveyId(Integer packageCode) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.SURVEY_ID_URL, new String[]{String.valueOf(packageCode)});
        return AiResponseUtils.resultHandler(responseContent, ScaleSurveyId.class);
    }
}
