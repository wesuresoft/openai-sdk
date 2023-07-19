package com.wesuresoft.sdk.enums;

import com.wesuresoft.sdk.config.AiConfig;
import com.wesuresoft.sdk.config.AiHostConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author zbq
 * @since 1.0.0
 */
public interface AiApiUrl {

    /**
     * 得到api完整地址.
     *
     * @param config 配置
     * @return api地址
     */
    default String getUrl(AiConfig config) {
        AiHostConfig hostConfig = null;
        if (Objects.nonNull(config)) {
            hostConfig = config.getHostConfig();
        }
        return AiHostConfig.buildUrl(hostConfig, this.getPrefix(), this.getPath());
    }

    /**
     * the path
     *
     * @return path
     */
    String getPath();

    /**
     * the prefix
     *
     * @return prefix
     */
    String getPrefix();

    @AllArgsConstructor
    @Getter
    enum Ocr implements AiApiUrl {

        /**
         * 血常规报告单识别
         */
        CBC_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/ocr/report");

        private final String prefix;
        private final String path;

    }

    @AllArgsConstructor
    @Getter
    enum AiOpen implements AiApiUrl {

        /**
         * 场景获取项目列表
         */
        SCENE_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/dis/scene"),

        /**
         * 疾病识别
         */
        PREDICT_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/dis/predict"),

        /**
         * 结果分析
         */
        EXPLAINER_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/dis/explainer");

        private final String prefix;
        private final String path;
    }

    @AllArgsConstructor
    @Getter
    enum Disease implements AiApiUrl {

        /**
         * 疾病科普
         */
        KNOWLEDGE_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/dis/knowledge");

        private final String prefix;
        private final String path;
    }

    @AllArgsConstructor
    @Getter
    enum Survey implements AiApiUrl {

        /**
         * 疾病问卷
         */
        SURVEY_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/survey"),

        /**
         * 问卷提交
         */
        SURVEY_SUBMIT_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/survey/submit");

        private final String prefix;
        private final String path;
    }

    @AllArgsConstructor
    @Getter
    enum User implements AiApiUrl {

        /**
         * 授权场景获取
         */
        AUTH_SCENE_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/open/user");

        private final String prefix;
        private final String path;
    }
}
