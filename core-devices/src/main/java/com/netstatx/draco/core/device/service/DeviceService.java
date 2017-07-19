package com.netstatx.draco.core.device.service;

import com.netstatx.draco.core.device.model.DeviceEntity;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface DeviceService {

    DeviceEntity findDeviceById(Long deviceId);

    DeviceEntity saveDevice(DeviceEntity deviceEntity);

    void deleteDevice(Long deviceId);
}
