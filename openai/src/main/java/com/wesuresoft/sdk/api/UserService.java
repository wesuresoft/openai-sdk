package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.bean.user.AuthSceneResult;

/**
 * @author zbq
 * @since 1.0.6
 */
public interface UserService {
    /**
     * 授权场景获取
     */
    AuthSceneResult getAuthScene() throws AiErrorException;
}
