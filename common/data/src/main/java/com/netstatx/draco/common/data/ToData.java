package com.netstatx.draco.common.data;

/**
 * Entity to DTO interface.
 *
 * @param <T> dto type
 * @author wangle<thisiswangle@gmail.com>
 */
public interface ToData<T> {
    T toData();
}
