package com.netstatx.draco.core.device.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {
    private String productName;
    private String productKey;
    private String productSecret;
    private String productDescription;
}
