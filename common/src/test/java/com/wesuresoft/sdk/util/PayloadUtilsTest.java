package com.wesuresoft.sdk.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author zbq
 * @since 2.0.0
 */
class PayloadUtilsTest {

    @Test
    void buildParam() {
        String param = PayloadUtils.buildParam("key1", "value1");
        Assertions.assertEquals("key1=value1", param);
    }

    @Test
    void testBuildParam() {
        String param = PayloadUtils.buildParam("key1", "value1", "key2", "value2");
        Assertions.assertEquals("key1=value1&key2=value2", param);
    }

    @Test
    void testBuildParam2() {
        String param = PayloadUtils.buildParam("key1", null, "key2", "value2");
        Assertions.assertEquals("key2=value2", param);
    }

    @Test
    void testBuildParam3() {
        String param = PayloadUtils.buildParam("key1", null);
        Assertions.assertNull(param);
    }
}