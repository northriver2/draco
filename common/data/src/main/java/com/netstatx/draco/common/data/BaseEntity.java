package com.netstatx.draco.common.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
public abstract class BaseEntity<T> implements ToData<T>, Serializable{
    private Long id;
    private Date gmtCreated;
    private Date gmtUpdated;

    public abstract Long generateId();

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
