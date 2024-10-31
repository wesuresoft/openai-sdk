package com.wesuresoft.sdk.bean.dict;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zbq
 * @since 2.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DiseaseInterface extends AiBaseResult<List<DiseaseInterface.Item>> {

    @Data
    public static class Item {
        /**
         * 疾病编码
         */
        private Integer code;

        /**
         * 疾病名称
         */
        private String name;

        /**
         * 疾病拼音码
         */
        private String pyCode;

        /**
         * 概述
         */
        private String overview;

        /**
         * 病因
         */
        private String cause;

        /**
         * 就医
         */
        private String visit;

        /**
         * 如何治疗
         */
        private String treatment;

        /**
         * 日常
         */
        private String daily;

        /**
         * 如何预防
         */
        private String prevention;

        /**
         * 疾病解释
         */
        private String definition;

        /**
         * 一类
         */
        private String type1;

        /**
         * 二类
         */
        private String type2;

        /**
         * icd10
         */
        private String icd10;

        private String symptoms;

        /**
         * 症状
         */
        private List<String> symptomList;

        public List<String> getSymptomList() {
            return symptomList == null || symptomList.isEmpty() ?
                    symptoms == null || symptoms.isEmpty() ? new ArrayList<>() : Arrays.asList(symptoms.split(",")) : symptomList;
        }
    }
}
