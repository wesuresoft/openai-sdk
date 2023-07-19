package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.bean.disease.KnowledgeResult;

/**
 * @author zbq
 * @since 1.0.0
 */
public interface DiseaseService {

    /**
     * 疾病科普
     *
     * @param diseaseCode 疾病编码
     */
    KnowledgeResult knowledge(Integer diseaseCode) throws AiErrorException;
}
