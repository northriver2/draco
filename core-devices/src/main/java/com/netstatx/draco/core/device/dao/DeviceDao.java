package com.netstatx.draco.core.device.dao;

import com.netstatx.draco.core.device.model.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Repository
public interface DeviceDao extends JpaRepository<DeviceEntity, Long>, JpaSpecificationExecutor {

    //DeviceEntity findById(Long id);

    // List<DeviceEntity> findAll(Specification<DeviceEntity> var1);
//    @Query("select u from User u where u.firstname = :name or u.lastname = :name")
//    List<DeviceEntity> queryDevice(String name);

}
