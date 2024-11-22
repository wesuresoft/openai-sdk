package com.wesuresoft.sdk.api.impl;

import com.wesuresoft.sdk.api.DictService;
import com.wesuresoft.sdk.api.OpenAiService;
import com.wesuresoft.sdk.bean.dict.DiseaseInterface;
import com.wesuresoft.sdk.bean.dict.ItemInterface;
import com.wesuresoft.sdk.bean.dict.PackageDetail;
import com.wesuresoft.sdk.bean.dict.PackagePrecondition;
import com.wesuresoft.sdk.enums.AiApiUrl;
import com.wesuresoft.sdk.util.AiResponseUtils;
import lombok.RequiredArgsConstructor;

import static com.wesuresoft.sdk.util.PayloadUtils.buildParam;

/**
 * @author zbq
 * @since 2.0.0
 */
@RequiredArgsConstructor
public class DictServiceImpl implements DictService {
    private final OpenAiService openAiService;

    @Override
    public ItemInterface standardItem(Integer testType) {
        String responseContent = this.openAiService.get(AiApiUrl.Dict.ITEM_URL, buildParam("testType", testType));
        return AiResponseUtils.resultHandler(responseContent, ItemInterface.class);
    }

    @Override
    public DiseaseInterface disease(Integer diseaseCode) {
        String responseContent = this.openAiService.get(AiApiUrl.Dict.DISEASE_URL, buildParam("diseaseCode", diseaseCode));
        return AiResponseUtils.resultHandler(responseContent, DiseaseInterface.class);
    }

    @Override
    public PackageDetail packages(Integer packageCode) {
        String responseContent = this.openAiService.get(AiApiUrl.Dict.PACKAGE_URL, buildParam("packageCode", packageCode));
        return AiResponseUtils.resultHandler(responseContent, PackageDetail.class);
    }

    @Override
    public ItemInterface packageItems(Integer packageCode) {
        String responseContent = this.openAiService.get(AiApiUrl.Dict.PACKAGE_ITEM_URL, buildParam("packageCode", packageCode));
        return AiResponseUtils.resultHandler(responseContent, ItemInterface.class);
    }

    @Override
    public PackagePrecondition packagePrecondition(Integer packageCode) {
        String responseContent = this.openAiService.get(AiApiUrl.Dict.PACKAGE_PRECONDITION_URL, buildParam("packageCode", packageCode));
        return AiResponseUtils.resultHandler(responseContent, PackagePrecondition.class);
    }
}
