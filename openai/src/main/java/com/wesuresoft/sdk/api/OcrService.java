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
     */
    OcrResult ocr(String[] imgContents, Integer reportType) throws AiErrorException;

    /**
     * ocr
     * 图像大于1M时建议进行压缩，可以使用FileUtils#getImageCom进行压缩
     *
     * @param imgContent 图像base64
     * @param reportType 报告类型 1 血常规 2 生化
     */
    default OcrResult ocr(String imgContent, Integer reportType) throws AiErrorException {
        return ocr(new String[]{imgContent}, reportType);
    }

    /**
     * ocr
     * 图像大于1M时建议进行压缩，可以使用FileUtils#getImageCom进行压缩
     *
     * @param imgContent 图像base64
     */
    default OcrResult ocr(String imgContent) throws AiErrorException {
        return ocr(new String[]{imgContent}, null);
    }

    /**
     * ocr
     *
     * @param files      文件数组
     * @param reportType 报告类型 1 血常规 2 生化
     */
    OcrResult ocr(File[] files, Integer reportType) throws IOException, AiErrorException;

    /**
     * ocr
     *
     * @param file       文件
     * @param reportType 报告类型 1 血常规 2 生化
     */
    default OcrResult ocr(File file, Integer reportType) throws IOException, AiErrorException {
        return ocr(new File[]{file}, reportType);
    }

    /**
     * ocr
     *
     * @param file 文件
     */
    default OcrResult ocr(File file) throws IOException, AiErrorException {
        return ocr(new File[]{file}, null);
    }

    /**
     * ocr
     *
     * @param imgUrl     图像网络地址
     * @param reportType 报告类型 1 血常规 2 生化
     */
    OcrResult ocr(Integer reportType, String... imgUrl) throws IOException, AiErrorException;

    /**
     * ocr
     *
     * @param imgUrl 图像网络地址
     */
    default OcrResult ocr(String... imgUrl) throws IOException, AiErrorException {
        return ocr(null, imgUrl);
    }
}
