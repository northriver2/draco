package com.netstatx.draco.common.data.auth;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface DeviceAuthService {
    <T> DeviceAuthResult<T> auth();
    void findDeviceById(Long deviceId);
}
