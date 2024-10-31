package com.wesuresoft.sdk.bean.dict;

import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PackagePrecondition extends AiBaseResult<List<PackageDetail.Precondition>> {
}
