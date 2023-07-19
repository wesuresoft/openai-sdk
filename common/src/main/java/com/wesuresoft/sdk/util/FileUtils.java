package com.wesuresoft.sdk.util;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

/**
 * copy org.springframework.util.FileCopyUtils
 * copy org.springframework.util.StreamUtils
 */
public class FileUtils {
    public static final int BUFFER_SIZE = 4096;

    /**
     * Copy the contents of the given input File into a new byte array.
     *
     * @param in the file to copy from
     * @return the new byte array that has been copied to
     * @throws IOException in case of I/O errors
     */
    public static byte[] copyToByteArray(File in) throws IOException {
        return copyToByteArray(Files.newInputStream(in.toPath()));
    }

    /**
     * Copy the contents of the given InputStream into a new byte array.
     * Closes the stream when done.
     *
     * @param in the stream to copy from (may be {@code null} or empty)
     * @return the new byte array that has been copied to (possibly empty)
     * @throws IOException in case of I/O errors
     */
    public static byte[] copyToByteArray(InputStream in) throws IOException {
        if (in == null) {
            return new byte[0];
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream(BUFFER_SIZE);
        copy1(in, out);
        return out.toByteArray();
    }


    /**
     * Copy the contents of the given InputStream to the given OutputStream.
     * Closes both streams when done.
     *
     * @param in  the stream to copy from
     * @param out the stream to copy to
     * @return the number of bytes copied
     * @throws IOException in case of I/O errors
     */
    public static int copy1(InputStream in, OutputStream out) throws IOException {
        try {
            return copy(in, out);
        } finally {
            close(in);
            close(out);
        }
    }

    /**
     * Copy the contents of the given InputStream to the given OutputStream.
     * <p>Leaves both streams open when done.
     *
     * @param in  the InputStream to copy from
     * @param out the OutputStream to copy to
     * @return the number of bytes copied
     * @throws IOException in case of I/O errors
     */
    public static int copy(InputStream in, OutputStream out) throws IOException {
        int byteCount = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
            byteCount += bytesRead;
        }
        out.flush();
        return byteCount;
    }


    /**
     * Attempt to close the supplied {@link Closeable}, silently swallowing any
     * exceptions.
     *
     * @param closeable the {@code Closeable} to close
     */
    private static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException ex) {
            // ignore
        }
    }


    /**
     * 图片URL转Base64编码
     *
     * @param imgUrl 图片URL
     * @return Base64编码
     */
    public static byte[] imageUrlToBase64(String imgUrl) throws IOException {
        if (StringUtils.isBlank(imgUrl)) {
            return new byte[0];
        }

        URL url;
        InputStream is = null;
        ByteArrayOutputStream outStream = null;
        HttpURLConnection httpUrl = null;

        try {
            url = new URL(imgUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();

            is = httpUrl.getInputStream();
            outStream = new ByteArrayOutputStream();

            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用输入流从buffer里把数据读取出来
            while ((len = is.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }

            return outStream.toByteArray();
        } finally {
            if (is != null) {
                is.close();
            }
            if (outStream != null) {
                outStream.close();
            }
            if (httpUrl != null) {
                httpUrl.disconnect();
            }
        }
    }

    /**
     * 图像压缩
     *
     * @param file 图像文件
     * @throws IOException /
     */
    public static byte[] getImageCom(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file)) {
            return imageCom(inputStream);
        }
    }

    /**
     * 图像压缩
     *
     * @param imgByte 图像byte数组
     * @throws IOException /
     */
    public static byte[] getImageCom(byte[] imgByte) throws IOException {
        try (ByteArrayInputStream byteInput = new ByteArrayInputStream(imgByte);) {
            return imageCom(byteInput);
        }
    }

    private static byte[] imageCom(InputStream inputStream) throws IOException {
        BufferedImage bufImg = ImageIO.read(inputStream);
        // 压缩代码,存储图片文件byte数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //防止图片变红,这一步非常重要
        BufferedImage bufferedImage = new BufferedImage(bufImg.getWidth(), bufImg.getHeight(), BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics().drawImage(bufImg, 0, 0, Color.WHITE, null);
        //先转成jpg格式来压缩,然后在通过OSS来修改成源文件本来的后缀格式
        ImageIO.write(bufferedImage, "jpg", bos);
        return bos.toByteArray();
    }
}
