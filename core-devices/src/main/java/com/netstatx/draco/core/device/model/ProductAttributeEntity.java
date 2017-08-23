package com.netstatx.draco.core.device.model;

import com.netstatx.draco.common.data.DataType;
import com.netstatx.draco.core.device.config.UuidGeneratorConfig;
import com.netstatx.draco.core.device.data.ProductAttribute;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author songwb<songwb@aliyun.com>
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_attribute")
public class ProductAttributeEntity extends BaseUuidEntity<ProductAttribute> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "attribute_code")
    private String attributeCode;
    @Column(name = "attribute_name")
    private String attributeName;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "data_type")
    private DataType dataType;
    @Column(name = "lower_limit")
    private float lowerLimit;
    @Column(name = "upper_limit")
    private float upperLimit;
    @Column(name = "packet")
    private String packet;
    @Column(name = "order_no")
    private int orderNo;
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private boolean enabled;

    public ProductAttributeEntity() {
    }

    @Override
    public ProductAttribute toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }
}
