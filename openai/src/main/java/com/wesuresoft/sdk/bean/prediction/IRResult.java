package com.wesuresoft.sdk.bean.prediction;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zbq
 * @since 2.0.3
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IRResult extends AiBaseResult<IRResult.Info> {

    @Data
    public static class Info {
        private String objectName;
        private String url;
        private String expiration;
    }
}
