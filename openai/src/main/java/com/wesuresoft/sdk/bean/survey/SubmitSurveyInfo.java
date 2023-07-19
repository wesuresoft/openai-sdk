package com.wesuresoft.sdk.bean.survey;

import com.google.gson.Gson;
import com.wesuresoft.sdk.util.MapUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
public class SubmitSurveyInfo {

    /**
     * 疾病预测请求id
     */
    private String requestId;

    /**
     * 问卷id
     */
    private String surveyId;

    /**
     * 选项list
     */
    private List<SurveyOption> items;


    @Data
    public static class SurveyOption {

        /**
         * 问题id
         */
        private String subjectId;

        /**
         * 选项id
         */
        private List<String> optionId;
    }

    public String toJsonStr() {
        List<HashMap<String, String>> itemList = this.items.stream().map(o -> {
            HashMap<String, String> temp = new HashMap<>();
            temp.put("subjectId", o.getSubjectId());
            temp.put("optionId", String.join(",", o.getOptionId()));
            return temp;
        }).collect(Collectors.toList());
        Map<String, Object> data = new HashMap<>();
        MapUtils.putNonNullValue(data, "requestId", this.requestId);
        data.put("surveyId", this.surveyId);
        data.put("items", itemList);
        return new Gson().toJson(data);
    }
}
