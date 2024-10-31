package com.wesuresoft.sdk.bean.prediction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PredictionParam {

    /**
     * 套餐编码
     */
    private Integer packageCode;

    /**
     * 疾病编码
     */
    private List<Integer> diseaseCodes;

    private String personId;

    /**
     * 姓名
     */
    private String name;

    private String reportId;

    /**
     * 请完善受检人年龄
     */
    private Integer age;

    /**
     * 请完善受检人性别 性别，0女 1男
     */
    private Integer gender;

    /**
     * 检验项目
     */
    private List<Item> items;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Item {
        /**
         * 中文名
         */
        private String cnName;
        /**
         * 英文名称
         */
        private String enName;
        /**
         * 结果
         */
        private String result;
        /**
         * 单位
         */
        private String unit;
    }
}
