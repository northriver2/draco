package com.netstatx.draco.core.device.model;

import com.netstatx.draco.core.device.data.Topic;
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
public class TopicEntity extends BaseUuidEntity<Topic> {
    private Long id;
    private Long deviceId;
    private String topicName;
    private Permission permission;

    @Override
    public Topic toData() {
        return null;
    }

    @Override
    public Long generateId() {
        return null;
    }

    public enum Permission {
        PUB, SUB, PUB_SUB
    }
}
