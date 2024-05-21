package com.wesuresoft.sdk.util;

/**
 * @author zbq
 * @since 1.2.0
 */
public class AiConfigHolder {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "default";
        }
    };

    public static String get() {
        return THREAD_LOCAL.get();
    }

    public static void set(String label) {
        THREAD_LOCAL.set(label);
    }

    /**
     * 此方法需要用户根据自己程序代码，在适当位置手动触发调用，本SDK里无法判断调用时机
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
