package com.netstatx.draco.common.data;

import java.util.List;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface Dao<T> {

    List<T> find();

    T findById(Long id);

    T save(T t);

    boolean removeById(Long id);

}
