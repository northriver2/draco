package com.netstatx.draco.core.device.model;

import com.netstatx.draco.core.device.config.UuidGeneratorConfig;
import com.netstatx.draco.core.device.data.Gateway;
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
@Table(name = "gateway")
public class GatewayEntity extends BaseUuidEntity<Gateway> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "gateway_code")
    private String gatewayCode;
    @Column(name = "gateway_name")
    private String gatewayName;
    @Column(name = "gateway_key")
    private String gatewayKey;
    @Column(name = "gateway_secret")
    private String gatewaySecret;
    @Column(name = "description")
    private String description;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "enabled")
    private boolean enabled;

    public GatewayEntity() {
    }

    @Override
    public Gateway toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }
}
