package com.wesuresoft.sdk.enums;

import com.wesuresoft.sdk.config.AiConfig;
import com.wesuresoft.sdk.config.AiHostConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

import static com.wesuresoft.sdk.config.AiHostConfig.OPEN_DEFAULT_HOST_URL;

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

    default String getUrl(AiConfig config, String... pathVariable) {
        AiHostConfig hostConfig = null;
        if (Objects.nonNull(config)) {
            hostConfig = config.getHostConfig();
        }
        return AiHostConfig.buildUrl(hostConfig, this.getPrefix(), String.format(this.getPath(), pathVariable));
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

        CBC_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/openai/api/ocr/report/content"),

        CBC_ML_URL(AiHostConfig.OPEN_DEFAULT_HOST_URL, "/openai/api/ocr/report/plus/content");

        private final String prefix;
        private final String path;

    }

    @AllArgsConstructor
    @Getter
    enum Dict implements AiApiUrl {

        ITEM_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/dict/item"),

        DISEASE_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/dict/disease"),

        PACKAGE_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/dict/package"),

        PACKAGE_ITEM_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/dict/package/item"),

        PACKAGE_PRECONDITION_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/dict/package/precondition");

        private final String prefix;
        private final String path;
    }

    @AllArgsConstructor
    @Getter
    enum Prediction implements AiApiUrl {

        PREDICT_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/predict"),

        SURVEY_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/survey"),

        SURVEY_RESULT_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/survey/result"),

        CREATE_PDF_URL(OPEN_DEFAULT_HOST_URL, "/report/create/pdf");

        private final String prefix;
        private final String path;
    }

    @AllArgsConstructor
    @Getter
    enum Scale implements AiApiUrl {

        LIST_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/scale/list"),

        SURVEY_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/scale/survey"),

        INSTRUCTION_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/scale/instruction"),

        SUBMIT_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/scale/submit"),

        RESULT_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/scale/result"),

        VIEW_URL(OPEN_DEFAULT_HOST_URL, "/openai/api/v2/scale/view");

        private final String prefix;
        private final String path;
    }
}
