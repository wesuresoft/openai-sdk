package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.AiResponseUtils;
import com.wesuresoft.sdk.api.DiseaseService;
import com.wesuresoft.sdk.bean.disease.KnowledgeResult;
import lombok.RequiredArgsConstructor;

/**
 * @author zbq
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {
    private final OpenAiService openAiService;

    @Override
    public KnowledgeResult knowledge(Integer diseaseCode) throws AiErrorException {
        String responseContent = this.openAiService.post(AiApiUrl.Disease.KNOWLEDGE_URL, String.format("{\"code\": %s}", diseaseCode));
        return AiResponseUtils.resultHandler(responseContent, KnowledgeResult.class);
    }
}
