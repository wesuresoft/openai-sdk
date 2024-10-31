package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.ocr.OcrResult;
import com.wesuresoft.sdk.error.AiErrorException;

import java.io.File;
import java.io.IOException;

/**
 * @author zbq
 * @since 1.0.0
 */
public interface OcrService {

    /**
     * ocr
     * 图像大于1M时建议进行压缩，可以使用FileUtils#getImageCom进行压缩
     *
     * @param imgContents 图像base64数组
     * @param reportType  报告类型 1 血常规 2 生化
     * @param isMl        是否为大模型解析
     */
    OcrResult ocr(String[] imgContents, Integer reportType, boolean isMl) throws AiErrorException;

    /**
     * ocr
     * 图像大于1M时建议进行压缩，可以使用FileUtils#getImageCom进行压缩
     *
     * @param imgContent 图像base64
     * @param reportType 报告类型 1 血常规 2 生化
     */
    default OcrResult ocr(String imgContent, Integer reportType) throws AiErrorException {
        return ocr(new String[]{imgContent}, reportType, false);
    }

    default OcrResult ocrMl(String imgContent, Integer reportType) throws AiErrorException {
        return ocr(new String[]{imgContent}, reportType, true);
    }

    /**
     * ocr
     * 图像大于1M时建议进行压缩，可以使用FileUtils#getImageCom进行压缩
     *
     * @param imgContent 图像base64
     */
    default OcrResult ocr(String imgContent) throws AiErrorException {
        return ocr(new String[]{imgContent}, null, false);
    }

    default OcrResult ocrMl(String imgContent) throws AiErrorException {
        return ocr(new String[]{imgContent}, null, true);
    }

    /**
     * ocr
     *
     * @param files      文件数组
     * @param reportType 报告类型 1 血常规 2 生化
     * @param isMl       是否为大模型解析
     */
    OcrResult ocr(File[] files, Integer reportType, boolean isMl) throws IOException, AiErrorException;

    /**
     * ocr
     *
     * @param file       文件
     * @param reportType 报告类型 1 血常规 2 生化
     */
    default OcrResult ocr(File file, Integer reportType) throws IOException, AiErrorException {
        return ocr(new File[]{file}, reportType, false);
    }

    default OcrResult ocrMl(File file, Integer reportType) throws IOException, AiErrorException {
        return ocr(new File[]{file}, reportType, true);
    }

    /**
     * ocr
     *
     * @param file 文件
     */
    default OcrResult ocr(File file) throws IOException, AiErrorException {
        return ocr(new File[]{file}, null, false);
    }

    default OcrResult ocrMl(File file) throws IOException, AiErrorException {
        return ocr(new File[]{file}, null, true);
    }

    /**
     * ocr
     *
     * @param imgUrl     图像网络地址
     * @param reportType 报告类型 1 血常规 2 生化
     * @param isMl       是否为大模型解析
     */
    OcrResult ocr(Integer reportType, boolean isMl, String... imgUrl) throws IOException, AiErrorException;

    default OcrResult ocr(Integer reportType, String... imgUrl) throws IOException, AiErrorException {
        return ocr(reportType, false, imgUrl);
    }

    default OcrResult ocrMl(Integer reportType, String... imgUrl) throws IOException, AiErrorException {
        return ocr(reportType, true, imgUrl);
    }

    /**
     * ocr
     *
     * @param imgUrl 图像网络地址
     */
    default OcrResult ocr(String... imgUrl) throws IOException, AiErrorException {
        return ocr(null, false, imgUrl);
    }

    default OcrResult ocrMl(String... imgUrl) throws IOException, AiErrorException {
        return ocr(null, true, imgUrl);
    }
}
