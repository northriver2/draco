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
public class Gateway implements BaseData {
    private Long id;
    private String gatewayCode;
    private String gatewayName;
    private String gatewayKey;
    private String gatewaySecret;
    private String gatewayDescription;
    private Long productId;
    private String ipAddress;
}
