package com.netstatx.draco.core.telemetry.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
public class Packet extends BaseModel {
    private String packetName;
    private Integer packetIndex;
    private String packetKey;
    private Long productId;
    private Status status;
    private Map<String, Field> fields;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
