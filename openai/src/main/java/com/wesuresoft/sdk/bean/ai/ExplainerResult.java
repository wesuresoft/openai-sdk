package com.wesuresoft.sdk.bean.ai;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExplainerResult extends AiBaseResult<ExplainerResult.DisExplainer> {

    @Data
    public static class DisExplainer {
        /**
         * 可选填
         */
        private String plot;

        /**
         * 可选填
         */
        private String fmt;

        /**
         * 图片清晰度
         */
        private Integer dpi;
        /**
         * 解释结果list
         */
        private List<ExplainerItem> itemList;

        @Data
        public static class ExplainerItem {
            /**
             * 模型id
             */
            private Long matchId;
            /**
             * 疾病编码
             */
            private Integer code;
            /**
             * 疾病名称
             */
            private String name;
            /**
             * 图像base64
             */
            private String base64Image;
            /**
             * 错误信息
             */
            private String errMsg;
        }
    }
}
