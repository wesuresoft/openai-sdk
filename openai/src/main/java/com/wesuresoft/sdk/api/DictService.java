package com.wesuresoft.sdk.api;

import com.wesuresoft.sdk.bean.dict.DiseaseInterface;
import com.wesuresoft.sdk.bean.dict.ItemInterface;
import com.wesuresoft.sdk.bean.dict.PackageDetail;
import com.wesuresoft.sdk.bean.dict.PackagePrecondition;

/**
 * @author zbq
 * @since 2.0.0
 */
public interface DictService {

    default ItemInterface standardItem() {
        return standardItem(null);
    }

    /**
     * 项目
     */
    ItemInterface standardItem(Integer testType);

    default DiseaseInterface disease() {
        return disease(null);
    }

    /**
     * 疾病相关信息
     */
    DiseaseInterface disease(Integer diseaseCode);

    default PackageDetail packages() {
        return packages(null);
    }

    /**
     * 套餐相关信息
     */
    PackageDetail packages(Integer packageCode);

    /**
     * 获取套餐入参列表
     */
    ItemInterface packageItems(Integer packageCode);

    /**
     * 获取套餐前置条件
     */
    PackagePrecondition packagePrecondition(Integer packageCode);
}
