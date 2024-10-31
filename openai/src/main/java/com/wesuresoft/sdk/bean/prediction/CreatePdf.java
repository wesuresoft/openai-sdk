package com.wesuresoft.sdk.bean.prediction;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zbq
 * @since 2.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CreatePdf extends AiBaseResult<CreatePdf.Item> {

    @Data
    public static class Item {
        /**
         * 文件路径
         */
        private String path;

        /**
         * Url
         */
        private String url;
    }
}
