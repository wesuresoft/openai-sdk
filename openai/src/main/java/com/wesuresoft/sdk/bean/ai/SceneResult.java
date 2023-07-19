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
public class SceneResult extends AiBaseResult<List<SceneResult.SceneItem>> {

    @Data
    public static class SceneItem {
        /**
         * 中文名称
         */
        private String cnName;

        /**
         * 英文名称
         */
        private String enName;

        /**
         * 英文别名
         */
        private String enViewAliase;

        /**
         * 中文别名
         */
        private String cnViewAliase;

        /**
         * 单位
         */
        private String unit;

        /**
         * 最大值
         */
        private String maxValue;

        /**
         * 最小值
         */
        private String minValue;

        /**
         * 入参顺序
         */
        private Integer paramIndex;

        /**
         * 所属分类 1 血常规 2 生化 3 基础类型
         */
        private Integer classification;

        /**
         * 项目科普
         */
        private String remark;
    }
}
