package com.wesuresoft.sdk.error;

import lombok.Getter;

/**
 * @author zbq
 * @since 1.0.0
 */
public class AiErrorException extends RuntimeException {
    public AiErrorException() {
        super();
    }

    public AiErrorException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AiErrorException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public AiErrorException(AiError error) {
        super(error.getMsg());
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    public AiErrorException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    @Getter
    private String msg;
    @Getter
    private Integer code;
}
