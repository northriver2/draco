package com.netstatx.draco.core.telemetry.model;

import com.netstatx.draco.core.telemetry.config.ContextWrapper;
import com.netstatx.draco.snowflake.client.SnowflakeClient;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@EqualsAndHashCode
public abstract class BaseModel {
    private Long id;
    private Date gmtCreated;
    private Date gmtUpdated;

    private Long generateId() {
        return ContextWrapper.getContext().getBean(SnowflakeClient.class).getUUID();
    }

    public void doPreSave() {
        if (id == null) {
            id = this.generateId();
        }

        Date now = new Date();
        if (this.getGmtCreated() == null) {
            this.setGmtCreated(now);
        }

        this.setGmtUpdated(now);
    }
}
