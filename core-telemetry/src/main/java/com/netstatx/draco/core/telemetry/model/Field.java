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
public class Field extends BaseEntity<Field> {
    private String fieldName;
    private Integer fieldIndex;
    private String fieldKey;
    private String packetId;
    private Status status;

    @Override
    public Field toData() {
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
