package com.wesuresoft.sdk.bean.disease;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class KnowledgeResult extends AiBaseResult<KnowledgeResult.Info> {

    @Data
    public static class Info {

        /**
         * 疾病编码
         */
        private Integer code;

        /**
         * 疾病名称
         */
        private String name;

        /**
         * 概述
         */
        private String overview;

        /**
         * 症状
         */
        private String symptom;

        /**
         * 病因
         */
        private String cause;

        /**
         * 就医
         */
        private String visit;

        /**
         * 治疗
         */
        private String treatment;

        /**
         * 日常
         */
        private String daily;

        /**
         * 预防
         */
        private String prevention;
    }
}
