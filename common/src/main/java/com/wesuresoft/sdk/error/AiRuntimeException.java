package com.wesuresoft.sdk.error;

/**
 * @author zbq
 * @since 1.0.0
 */
public class AiRuntimeException extends RuntimeException {
    public AiRuntimeException(Throwable e) {
        super(e);
    }

    public AiRuntimeException(String msg) {
        super(msg);
    }

    public AiRuntimeException(String msg, Throwable e) {
        super(msg, e);
    }
}
