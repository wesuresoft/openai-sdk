package com.wesuresoft.sdk.bean.ai;

import com.google.gson.Gson;
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
public class PredictInfo {
    /**
     * 场景code
     */
    private Integer sceneCode;

    /**
     * 疾病code列表
     */
    private List<Integer> diseasesCodes;

    /**
     * 检验结果项
     */
    private List<ResultItem> resultItems;

    @Data
    public static class ResultItem {
        /**
         * 结果项英文名称
         */
        private String key;

        /**
         * 结果项值
         */
        private String value;
    }

    public String toJsonStr() {
        Map<String, String> items = this.resultItems.stream().collect(Collectors.toMap(ResultItem::getKey, ResultItem::getValue));
        Map<String, Object> data = new HashMap<>();
        data.put("scene", sceneCode);
        data.put("diseases", diseasesCodes.toArray(new Integer[0]));
        data.put("items", items);
        return new Gson().toJson(data);
    }
}
