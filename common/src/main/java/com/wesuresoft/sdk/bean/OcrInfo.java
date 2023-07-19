package com.wesuresoft.sdk.bean;

import lombok.Data;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
public class OcrInfo {

    /**
     * 图片 base64 编码
     */
    private String[] imgContents;
    /**
     * 报告类型
     * <p>
     * 1 血常规 2 生化
     */
    private Integer reportType = 1;

    public String getImgDataStr() {
        return String.join(",", imgContents);
    }
}
