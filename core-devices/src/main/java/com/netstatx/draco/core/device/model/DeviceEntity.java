package com.netstatx.draco.core.device.model;

import com.netstatx.draco.core.device.config.UuidGeneratorConfig;
import com.netstatx.draco.core.device.data.Device;
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
@Table(name = "device")
public class DeviceEntity extends BaseUuidEntity<Device> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "device_code")
    private String deviceCode;
    @Column(name = "device_name")
    private String deviceName;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "gateway_id")
    private Long gatewayId;
    @Column(name = "enabled")
    private boolean enabled;

    public DeviceEntity() {
    }

    @Override
    public Device toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }

}
