package com.wesuresoft.sdk.api;

import com.google.gson.Gson;
import com.wesuresoft.sdk.bean.prediction.CreatePdfParam;
import com.wesuresoft.sdk.bean.prediction.PredictionParam;
import com.wesuresoft.sdk.bean.prediction.SurveyParam;
import com.wesuresoft.sdk.bean.prediction.ir.IRHzbLiaoParam;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author zbq
 * @since 2.0.0
 */
class PredictionServiceTest {
    private static PredictionService predictionService;

    @BeforeAll
    public static void init() {
        predictionService = TestContext.init().getPredictionService();
    }

    @Test
    void predict() {
        String jsonStr = "{\"age\": 20,\"diseaseCodes\": [],\"packageCode\": 2001002,\"gender\": 0,\"items\": [{\"enName\": \"RBC\",\"result\": \"4.3\"},{\"enName\": \"PDW\",\"result\": \"16.2\"},{\"enName\": \"WBC\",\"result\": \"7.44\"},{\"enName\": \"NEUT\",\"result\": \"4.8\"},{\"enName\": \"LYMPH\",\"result\": \"2.09\"},{\"enName\": \"BASO\",\"result\": \"0.01\"},{\"enName\": \"HGB\",\"result\": \"155\"},{\"enName\": \"HCT\",\"result\": \"0.441\"},{\"enName\": \"R-CV\",\"result\": \"12.2\"},{\"enName\": \"PLT\",\"result\": \"258\"},{\"enName\": \"MPV\",\"result\": \"9.9\"},{\"enName\": \"PCT\",\"result\": \"0.26\"},{\"enName\": \"MONO\",\"result\": \"0.29\"},{\"enName\": \"EO\",\"result\": \"0.25\"}],\"name\": \"test1\",\"personId\": \"test1\"}";
        PredictionParam param = new Gson().fromJson(jsonStr, PredictionParam.class);
        assertNotNull(predictionService.predict(param));
    }

    @Test
    void downloadSurvey() {
        assertNotNull(predictionService.downloadSurvey("1851868927371612162"));
    }

    @Test
    void submitSurvey() {
        SurveyParam param = new SurveyParam();
        param.setSurveyNo("1851868927371612162");
        SurveyParam.Item item = new SurveyParam.Item();
        item.setId(111L);
        item.setOptions("189");
        param.setItems(Collections.singletonList(item));
        assertNotNull(predictionService.submitSurvey(param));
    }

    @Test
    void downloadResult() {
        assertNotNull(predictionService.downloadResult("APIV2:2dafec50a8be5567a99c1672a8c63b71"));
    }

    @Test
    void surveyResult() {
        assertNotNull(predictionService.surveyResult("1851868927371612162"));
    }

    @Test
    void createPdf() {
        String jsonStr = "{\"report\": {\"tplMd5\": \"12d3434351148e0bda4b44a4b24281af\",\"tplUuid\": \"\",\"templateContentId\": null,\"tplName\": \"糖并\",\"paperCode\": null,\"rptUploadUrl\": null,\"remark\": null,\"tplDownloadUrl\": \"https://jf.chnlis.com:2170/dis-identify-api/yzb/report/template/download/19\",\"tplUploadUrl\": null,\"report_PATH\": null},\"dataset\": {\"recordNo\": \"APIV2:7a6050463d717373b6a2a01eb2e9925f\",\"symptom1\": [{\"symptom\": null}],\"patientInfo\": [{\"doctor\": \"\",\"gender\": \"男\",\"patType\": \"\",\"name\": \"测试报表服务\",\"testTime\": \"\",\"generateTime\": \"\",\"department\": \"\",\"age\": 56}],\"hospital\": [{\"name\": \"测试机构2\",\"shortName\": \"test2\",\"phone\": \"1234\",\"address\": \"西安\"}]}}";
        CreatePdfParam param = new Gson().fromJson(jsonStr, CreatePdfParam.class);
        assertNotNull(predictionService.createPdf(param));
    }

    @Test
    void getUrlIR() {
        assertNotNull(predictionService.getUrlIR("report/568dfd72-08b3-xxxx-9dc5-c89638551640.pdf"));
    }

    @Test
    void creatPdfIR() {
        String jsonStr = "{\"gender\": \"男\",\"hospitalName\": \"1公卫体检\",\"generateTime\": \"2025-11-22\",\"type\": \"体检\",\"name\": \"测试T\",\"packageName\": \"[糖尿病并发症]\",\"riskOverview\": {\"riskLevel\": 2,\"historyList\": [{\"date\": 1732261213000,\"risk\": 0.468034}],\"predict\": 0.468034,\"introduction\": \"根据AI评估结果，您存在轻微的糖尿病并发症风险。您需要更加关注自己的健康状况，采取更加积极的措施来降低并发症的风险。建议您与您的医生保持紧密的联系，调整治疗方案，如优化用药、加强血糖监测等。同时，注意改善饮食更好的管理糖尿病来降低并发症的风险！\"},\"age\": 31}";
        IRHzbLiaoParam param = new Gson().fromJson(jsonStr, IRHzbLiaoParam.class);
        assertNotNull(predictionService.creatPdfIR(param, "hzb_liao"));
    }
}