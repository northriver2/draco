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
public class Device extends BaseModel {
    private String deviceName;
    private String deviceKey;
    private String deviceSecret;
    private Boolean gateway;
    private Status status;
    private Long productId;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
