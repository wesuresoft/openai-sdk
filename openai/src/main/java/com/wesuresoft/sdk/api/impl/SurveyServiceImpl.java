package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.bean.survey.SubmitSurveyInfo;
import com.wesuresoft.sdk.bean.survey.SurveyResult;
import com.wesuresoft.sdk.bean.survey.SurveySubmitResult;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.AiResponseUtils;
import com.wesuresoft.sdk.util.MapUtils;
import com.wesuresoft.sdk.api.SurveyService;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zbq
 * @since 1.0.6
 */
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final OpenAiService openAiService;

    @Override
    public SurveyResult survey(Integer diseaseCode, Integer surveyType) throws AiErrorException {
        Map<String, Object> data = new HashMap<>();
        data.put("diseaseCode", diseaseCode);
        MapUtils.putNonNullValue(data, "surveyType", surveyType);
        String responseContent = this.openAiService.post(AiApiUrl.Survey.SURVEY_URL, MapUtils.toJsonStr(data));
        return AiResponseUtils.resultHandler(responseContent, SurveyResult.class);
    }

    @Override
    public SurveySubmitResult surveySubmit(SubmitSurveyInfo info) throws AiErrorException {
        String responseContent = this.openAiService.post(AiApiUrl.Survey.SURVEY_SUBMIT_URL, info.toJsonStr());
        return AiResponseUtils.resultHandler(responseContent, SurveySubmitResult.class);
    }
}
