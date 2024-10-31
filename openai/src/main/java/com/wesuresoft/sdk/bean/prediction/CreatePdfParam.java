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
public class CreatePdfParam {

    /**
     * 报告参数
     */
    private ReportDTO report;

    /**
     * 数据体
     */
    private DatasetDTO dataset;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ReportDTO {
        private String tplMd5;
        private String tplUuid;
        private Object templateContentId;
        private String tplName;
        private Object paperCode;
        private Object rptUploadUrl;
        private Object remark;
        private String tplDownloadUrl;
        private Object tplUploadUrl;
        private Object report_PATH;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class DatasetDTO {
        /**
         * 识别接口返回的识别标识
         */
        private String recordNo;
        private List<HospitalDTO> hospital;
        private List<PatientInfoDTO> patientInfo;
        private List<Symptom1DTO> symptom1;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class HospitalDTO {
        /**
         * 名称
         */
        private String name;
        /**
         * 简称
         */
        private String shortName;
        /**
         * 联系电话
         */
        private String phone;
        /**
         * 地址
         */
        private String address;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PatientInfoDTO {
        /**
         * 医生
         */
        private String doctor;
        /**
         * 性别 男/女
         */
        private String gender;
        /**
         * 就诊类型
         */
        private String patType;
        /**
         * 姓名
         */
        private String name;
        /**
         * 检测时间
         */
        private String testTime;
        /**
         * 生成时间
         */
        private String generateTime;
        /**
         * 科室
         */
        private String department;
        /**
         * 年龄
         */
        private Integer age;
    }


    public static class Symptom1DTO {
        private String symptom;
    }
}
