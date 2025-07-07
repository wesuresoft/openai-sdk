package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.api.ScaleService;
import com.wesuresoft.sdk.bean.scale.*;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.error.AiError;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.AiResponseUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

import static com.wesuresoft.sdk.enums.AiApiUrl.Scale.IMAGE_URL;
import static com.wesuresoft.sdk.util.PayloadUtils.buildParam;
import static com.wesuresoft.sdk.util.PayloadUtils.toJsonStr;

/**
 * @author zbq
 * @since 2.0.0
 */
@Slf4j
@AllArgsConstructor
public class ScaleServiceImpl implements ScaleService {
    private final OpenAiService openAiService;

    @Override
    public ScaleSurveyInfo getScaleList(String type) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.LIST_URL, buildParam("type", type));
        return AiResponseUtils.resultHandler(responseContent, ScaleSurveyInfo.class);
    }

    @Override
    public SurveySubject getScaleSubject(Integer surveyId) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.SURVEY_URL, buildParam("surveyId", surveyId));
        return AiResponseUtils.resultHandler(responseContent, SurveySubject.class);
    }

    @Override
    public ScaleInfo getScaleInfo(String type) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.INSTRUCTION_URL, buildParam("type", type));
        return AiResponseUtils.resultHandler(responseContent, ScaleInfo.class);
    }

    @Override
    public ScaleSubject submitScaleSubject(ScaleSurveySubmitParam param) {
        String responseContent = this.openAiService.post(AiApiUrl.Scale.SUBMIT_URL, toJsonStr(param));
        return AiResponseUtils.resultHandler(responseContent, ScaleSubject.class);
    }

    @Override
    public SurveySubject getSubmitScaleSubject(String recordNo, Integer surveyId) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.RESULT_URL,
                buildParam("recordNo", recordNo, "surveyId", surveyId));
        return AiResponseUtils.resultHandler(responseContent, SurveySubject.class);
    }

    @Override
    public ScaleSurvey getScaleView(String recordNo, Integer surveyId) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.VIEW_URL,
                buildParam("recordNo", recordNo, "surveyId", surveyId));
        return AiResponseUtils.resultHandler(responseContent, ScaleSurvey.class);
    }

    @Override
    public ScaleSurvey getScaleView(String recordNo, Integer surveyId, String dir) {
        ScaleSurvey scaleView = getScaleView(recordNo, surveyId);
        if (Optional.ofNullable(scaleView).map(ScaleSurvey::getData).map(ScaleSurvey.Item::getImgPath).isPresent()) {
            String imgPath = scaleView.getData().getImgPath();
            Path path = Paths.get(dir, imgPath);
            Path parent = path.getParent();
            if (!Files.exists(parent)) {
                try {
                    Files.createDirectories(parent);
                } catch (IOException e) {
                    throw new AiErrorException(e);
                }
            }

            downloadFile(String.format(IMAGE_URL.getUrl(this.openAiService.getAiConfig(), imgPath)), path);
        }

        return scaleView;
    }

    @Override
    public ScaleSurveyId getScaleSurveyId(Integer packageCode) {
        String responseContent = this.openAiService.get(AiApiUrl.Scale.SURVEY_ID_URL, new String[]{String.valueOf(packageCode)});
        return AiResponseUtils.resultHandler(responseContent, ScaleSurveyId.class);
    }

    private void downloadFile(String url, Path path) {
        CloseableHttpClient httpClient = (CloseableHttpClient) this.openAiService.getRequestHttp().getRequestHttpClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", ContentType.WILDCARD.getMimeType());
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            int statusCode = response.getStatusLine().getStatusCode();
            Header contentType = response.getFirstHeader(HttpHeaders.CONTENT_TYPE);
            boolean isJsonContentType = Objects.nonNull(contentType) && ContentType.APPLICATION_JSON.getMimeType()
                    .equals(ContentType.parse(String.valueOf(contentType.getValue())).getMimeType());
            if (HttpStatus.SC_OK == statusCode && !isJsonContentType) {
                log.info("\n【请求地址】：{}\n", url);
                try (InputStream inputStream = response.getEntity().getContent();
                     OutputStream outputStream = Files.newOutputStream(path)) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                }
                return;
            }

            //有错误提示信息返回
            String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            throw new AiErrorException(AiResponseUtils.resultHandler(responseString, AiError.class));
        } catch (IOException e) {
            log.error("\n【请求地址】：{}\n【异常信息】：{}", url, e.getMessage());
            throw new AiErrorException(e);
        } finally {
            httpGet.releaseConnection();
        }

    }
}
