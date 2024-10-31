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
public class PackageDetail extends AiBaseResult<List<PackageDetail.Item>> {

    @Data
    public static class Item {
        /**
         * 编码
         */
        private Integer packageCode;

        /**
         * 名称
         */
        private String packageName;

        /**
         * 分类
         */
        private String flag;

        /**
         * 年龄下限
         */
        private Integer minAge;

        /**
         * 年龄上限
         */
        private Integer maxAge;

        /**
         * 性别
         */
        private Integer gender;

        /**
         * 描述
         */
        private String description;

        /**
         * 症状启用
         */
        private Boolean symptomEnable;

        /**
         * 前提条件启用
         */
        private Boolean preconditionEnable;

        /**
         * 前提条件合格分
         */
        private Integer preconditionThreshold;

        /**
         * 备注
         */
        private String remark;

        /**
         * 前提条件
         */
        private List<Precondition> preconditionList;

        /**
         * 疾病信息
         */
        private List<DiseaseInfo> diseaseList;

        private List<PackageInput> inputItemList;
    }

    @Data
    public static class Precondition {

        private Long id;

        /**
         * 套餐编码
         */
        private Integer packageCode;

        /**
         * 问题字典id
         */
        private Integer baseId;

        /**
         * 问题名称
         */
        private String title;

        /**
         * 问题描述
         */
        private String description;

        /**
         * 题目标签
         */
        private String label;

        /**
         * 题目分数
         */
        private Integer score;

        /**
         * 选项类型 CHECKBOX, RADIO, INPUT
         */
        private String optionType;

        /**
         * 问题排序号
         */
        private Integer sortNum;

        /**
         * 逻辑删除
         */
        private Boolean isUse;

        /**
         * 选项列表
         */
        private List<Option> optionList;
    }


    @Data
    public static class Option {
        private Long id;

        /**
         * 疾病题目id
         */
        private Long preconditionSubjectId;

        /**
         * 场景编码
         */
        private Integer packageCode;

        /**
         * 选项名称
         */
        private String title;

        /**
         * 选项分值
         */
        private Integer score;

        /**
         * 选项排序号
         */
        private Integer sortNum;
    }


    @Data
    public static class PackageInput {

        private Integer itemId;

        /**
         * 中文名
         */
        private String cnName;

        /**
         * 英文名
         */
        private String enName;

        /**
         * 排序
         */
        private Integer sortNum;
    }

    @Data
    public static class DiseaseInfo {
        /**
         * 记录id
         */
        private Long id;

        /**
         * 编码
         */
        private Integer diseaseCode;

        /**
         * 名称
         */
        private String diseaseName;

        /**
         * 级别
         */
        private Integer diseaseLevel;

        /**
         * 父级编码
         */
        private Integer diseaseParent;

        /**
         * 年龄下限
         */
        private Integer minAge;

        /**
         * 年龄上限
         */
        private Integer maxAge;

        /**
         * 年龄范围下限
         */
        private Integer rangeMinAge;

        /**
         * 年龄范围上限
         */
        private Integer rangeMaxAge;

        /**
         * 适用性别
         */
        private Integer gender;

        /**
         * 疾病解释
         */
        private String definition;

        /**
         * 低风险描述
         */
        private String lowRiskDesc;

        /**
         * 中风险描述
         */
        private String mediumRiskDesc;

        /**
         * 高风险描述
         */
        private String highRiskDesc;

    }
}
