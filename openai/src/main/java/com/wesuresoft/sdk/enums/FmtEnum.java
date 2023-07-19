package com.wesuresoft.sdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zbq
 * @since 1.0.0
 */
@AllArgsConstructor
public enum FmtEnum {
    PNG("png"),
    SVG("svg"),
    JPG("jpg");

    @Getter
    private final String value;
}
