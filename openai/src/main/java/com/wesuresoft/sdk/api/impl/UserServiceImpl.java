package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.error.AiErrorException;
import com.wesuresoft.sdk.util.AiResponseUtils;
import com.wesuresoft.sdk.api.UserService;
import com.wesuresoft.sdk.bean.user.AuthSceneResult;
import lombok.RequiredArgsConstructor;

/**
 * @author zbq
 * @since 1.0.6
 */
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final OpenAiService openAiService;

    @Override
    public AuthSceneResult getAuthScene() throws AiErrorException {
        String responseContent = this.openAiService.get(AiApiUrl.User.AUTH_SCENE_URL, null);
        return AiResponseUtils.resultHandler(responseContent, AuthSceneResult.class);
    }
}
