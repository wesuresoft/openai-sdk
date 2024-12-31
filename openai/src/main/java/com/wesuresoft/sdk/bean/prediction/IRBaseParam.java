package com.wesuresoft.sdk.bean.prediction;

import lombok.Data;

/**
 * @author zbq
 * @since 2.0.3
 */
@Data
public class IRBaseParam {
    private String hospitalName;
    private String name;
    private String gender;
    private Integer age;
    private String generateTime;
    private String type;
    private String packageName;
}
