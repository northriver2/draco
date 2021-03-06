package com.netstatx.draco.core.device.data;


import com.netstatx.draco.common.data.BaseData;
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
@EqualsAndHashCode
public class Device implements BaseData {
    private Long id;
    private String deviceCode;
    private String deviceName;
    private Long productId;
    private Long gatewayId;
    private boolean enabled;
}
