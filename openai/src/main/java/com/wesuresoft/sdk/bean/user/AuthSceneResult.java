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
    }
}
