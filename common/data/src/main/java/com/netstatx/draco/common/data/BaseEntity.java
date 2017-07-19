package com.netstatx.draco.common.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseEntity<T> implements ToData<T>, Serializable{
    protected abstract Long getId();
    protected abstract void setId(Long id);
    private Date gmtCreated;
    private Date gmtUpdated;

    protected abstract Long generateId();

    public void doPreSave() {
        if (getId() == null) {
             setId(generateId());
        }

        Date now = new Date();
        if (this.getGmtCreated() == null) {
            this.setGmtCreated(now);
        }

        this.setGmtUpdated(now);
    }
}
