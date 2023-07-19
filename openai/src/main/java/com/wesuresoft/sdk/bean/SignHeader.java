package com.wesuresoft.sdk.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/**
 * @author zbq
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignHeader {
    /**
     * 授权
     */
    private String authorization;
    /**
     * 版本号
     */
    private String version;
    /**
     * 时间戳
     */
    private String timestamp;

    public Header[] toHeaders() {
        Header auth = new BasicHeader("Authorization", authorization);
        Header ver = new BasicHeader("Version", version);
        Header time = new BasicHeader("Timestamp", timestamp);
        return new Header[]{auth, ver, time};
    }
}
