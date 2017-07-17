package com.netstatx.draco.core.device.service;

import com.netstatx.draco.core.device.model.Device;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface DeviceService {

    Device findDeviceById(Long deviceId);

    Device saveDevice(Device device);

    void deleteDevice(Long deviceId);
}
