package com.netstatx.draco.core.device.dao;

import com.netstatx.draco.core.device.model.ProductMessageTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author songwb<songwb@aliyun.com>
 */
@Repository
public interface ProductMessageTypeDao extends JpaRepository<ProductMessageTypeEntity, Long>, JpaSpecificationExecutor {

}
