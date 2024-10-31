package com.wesuresoft.sdk.bean.scale;

import com.google.gson.JsonObject;
import com.wesuresoft.sdk.bean.AiBaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zbq
 * @since 2.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ScaleInfo extends AiBaseResult<List<JsonObject>> {

}
