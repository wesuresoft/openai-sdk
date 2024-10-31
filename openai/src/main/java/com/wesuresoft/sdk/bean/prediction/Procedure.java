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
public class Procedure extends AiBaseResult<Procedure.Item> {

    @Data
    public static class Item {
        /**
         * 识别记录标识
         */
        private String recordNo;

        /**
         * 问卷标识
         */
        private String surveyNo;
    }
}
