package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.AiService;
import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.bean.ai.ExplainerResult;
import com.wesuresoft.sdk.bean.ai.PredictInfo;
import com.wesuresoft.sdk.bean.ai.PredictResult;
import com.wesuresoft.sdk.bean.ai.SceneResult;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.enums.FmtEnum;
import com.wesuresoft.sdk.enums.PlotEnum;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.AiResponseUtils;
import com.wesuresoft.sdk.util.MapUtils;
import com.wesuresoft.sdk.util.http.HtmlRequestExecutor;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zbq
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class AiServiceImpl implements AiService {
    private final OpenAiService openAiService;

    @Override
    public SceneResult getSceneItem(Integer sceneCode) throws AiErrorException {
        String responseContent = this.openAiService.post(AiApiUrl.AiOpen.SCENE_URL, String.format("{\"code\": %s}", sceneCode));
        return AiResponseUtils.resultHandler(responseContent, SceneResult.class);
    }

    @Override
    public PredictResult predict(PredictInfo info) throws AiErrorException {
        String responseContent = this.openAiService.post(AiApiUrl.AiOpen.PREDICT_URL, info.toJsonStr());
        return AiResponseUtils.resultHandler(responseContent, PredictResult.class);
    }

    @Override
    public ExplainerResult explain(String requestId, Long[] matchId, PlotEnum plot, FmtEnum fmt, Integer dpi) throws AiErrorException {
        Map<String, Object> data = new HashMap<>();
        data.put("requestId", requestId);
        data.put("plot", Objects.nonNull(plot) ? plot.getValue() : "force");
        data.put("fmt", Objects.nonNull(fmt) ? fmt.getValue() : "png");
        MapUtils.putNonNullValue(data, "matchId", matchId);
        String responseContent = this.openAiService.post(AiApiUrl.AiOpen.EXPLAINER_URL, MapUtils.toJsonStr(data));
        return AiResponseUtils.resultHandler(responseContent, ExplainerResult.class);
    }

    @Override
    public String generateReportHtml(String... requestId) throws AiErrorException {
        String url = AiApiUrl.AiOpen.REPORT_URL.getUrl(openAiService.getAiConfig(), String.join(",", requestId));
        return this.openAiService.execute(HtmlRequestExecutor.create(this.openAiService.getRequestHttp()), url, null);
    }
}
