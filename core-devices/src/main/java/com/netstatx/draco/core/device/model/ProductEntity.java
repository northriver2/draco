package com.netstatx.draco.core.device.model;

import com.netstatx.draco.core.device.config.UuidGeneratorConfig;
import com.netstatx.draco.core.device.data.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
public class ProductEntity extends BaseUuidEntity<Product> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "product_code")
    private String productCode;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private boolean enabled;

    public ProductEntity() {
    }
    @Override
    public Product toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }
}
