package com.netstatx.draco.core.device.model;

import com.netstatx.draco.common.data.BaseEntity;
import com.netstatx.draco.core.device.config.UuidGeneratorConfig;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public abstract class BaseUuidEntity<T> extends BaseEntity<T> {
    @Override
    public Long generateId() {
        return UuidGeneratorConfig.getUUID();
    }
}
