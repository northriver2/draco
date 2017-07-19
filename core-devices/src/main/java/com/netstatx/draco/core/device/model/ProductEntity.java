package com.netstatx.draco.core.device.model;

import com.netstatx.draco.core.device.config.UuidGeneratorConfig;
import com.netstatx.draco.core.device.data.Product;
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
public class ProductEntity extends BaseUuidEntity<Product> {
    private Long id;
    private String productName;
    private String productKey;
    private String productSecret;
    private String productDescription;

    @Override
    public Product toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }
}
