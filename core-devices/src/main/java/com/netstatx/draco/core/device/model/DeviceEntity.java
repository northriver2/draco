package com.netstatx.draco.core.device.model;

import com.netstatx.draco.common.data.BaseEntity;
import com.netstatx.draco.core.device.config.UuidGeneratorConfig;
import com.netstatx.draco.core.device.data.Device;
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
public class DeviceEntity extends BaseEntity<Device> {
    private String deviceName;
    private String deviceKey;
    private String deviceSecret;
    private Boolean gateway;
    private Status status;
    private Long productId;

    @Override
    public Device toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }

    public enum Status {
        ACTIVE, INACTIVE
    }
}
