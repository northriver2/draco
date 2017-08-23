package com.netstatx.draco.core.device.model;

import com.netstatx.draco.core.device.config.UuidGeneratorConfig;
import com.netstatx.draco.core.device.data.ProductMessageType;
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
@Table(name = "product_message")
public class ProductMessageTypeEntity extends BaseUuidEntity<ProductMessageType> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "message_code")
    private String messageCode;
    @Column(name = "message_name")
    private String messageName;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private boolean enabled;

    public ProductMessageTypeEntity() {
    }

    @Override
    public ProductMessageType toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }
}
