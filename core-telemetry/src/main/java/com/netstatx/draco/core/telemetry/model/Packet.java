package com.netstatx.draco.core.telemetry.model;

import com.netstatx.draco.common.data.BaseEntity;
import com.netstatx.draco.core.telemetry.config.UuidGeneratorConfig;
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
public class Packet extends BaseEntity<Packet> {
    private String packetName;
    private Integer packetIndex;
    private String packetKey;
    private Long productId;
    private Status status;
    private Map<String, Field> fields;

    @Override
    public Packet toData() {
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
