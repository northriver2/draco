package com.netstatx.draco.core.device.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@ToString
@Builder
@EqualsAndHashCode(callSuper = true)
public class Topic extends BaseEntity {
    private Long deviceId;
    private String topicName;
    private Permission permission;

    public enum Permission {
        PUB, SUB, PUB_SUB
    }
}
