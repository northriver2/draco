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
public class Field extends BaseModel {
    private String fieldName;
    private Integer fieldIndex;
    private String fieldKey;
    private String packetId;
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
