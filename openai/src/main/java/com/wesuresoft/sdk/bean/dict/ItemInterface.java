package com.wesuresoft.sdk.bean.dict;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ItemInterface extends AiBaseResult<List<ItemInterface.Item>> {

    @Data
    public static class Item {
        private Long id;

        /**
         * 中文名称
         */
        private String cnName;

        /**
         * 英文名称
         */
        private String enName;

        /**
         * 拼音码
         */
        private String pyCode;

        /**
         * 中文别名
         */
        private String cnAlias;

        /**
         * 英文别名
         */
        private String enAlias;

        /**
         * 显示顺序
         */
        private Integer sortNum;

        /**
         * 模型识别极值高值
         */
        private String maxValue;

        /**
         * 模型识别极值低值
         */
        private String minValue;

        /**
         * 参考范围高值
         */
        private String rangeMaxValue;

        /**
         * 参考范围低值
         */
        private String rangeMinValue;

        /**
         * 参考值
         */
        private String referenceRange;

        /**
         * 单位
         */
        private String unit;

        /**
         * 检验类型 1 血常规  2 生化
         */
        private Integer testType;

        /**
         * 备注
         */
        private String remark;
    }
}
