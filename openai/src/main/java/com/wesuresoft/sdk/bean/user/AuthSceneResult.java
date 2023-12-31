package com.wesuresoft.sdk.bean.user;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbq
 * @since 1.0.6
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthSceneResult extends AiBaseResult<List<AuthSceneResult.SceneInfo>> {

    @Data
    public static class SceneInfo {
        /**
         * 场景code
         */
        private Integer sceneCode;
        /**
         * 场景名称
         */
        private String sceneName;
        /**
         * 场景描述
         */
        private String description;

        /**
         * 疾病信息
         */
        private List<DiseaseInfo> disease;
    }

    @Data
    public static class DiseaseInfo {
        /**
         * 疾病code
         */
        private Integer diseaseCode;
        /**
         * 疾病名称
         */
        private String diseaseName;
        /**
         * 性别 男、女、不限
         */
        private String gender;
        /**
         * 年龄最大值
         */
        private Integer maxAge;
        /**
         * 年龄最小值
         */
        private Integer minAge;
        /**
         * icd10编码
         */
        private String icd10;
        /**
         * 建议科室
         */
        private String suggestDepartment;
        /**
         * 低风险描述
         */
        private String lowRiskDesc;
        /**
         * 中风险描述
         */
        private String mediumRiskDesc;
        /**
         * 高风险描述
         */
        private String highRiskDesc;
        /**
         * 所属系统
         */
        private String diseaseSystem;
    }
}
