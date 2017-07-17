package com.netstatx.draco.core.device.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@Builder
@ToString
public class Product extends BaseModel {
    private String productName;
    private String productKey;
    private String productSecret;
    private String productDescription;
}
