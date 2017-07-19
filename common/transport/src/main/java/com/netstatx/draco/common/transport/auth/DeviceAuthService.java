package com.netstatx.draco.common.transport.auth;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface DeviceAuthService {
    <T> DeviceAuthResult<T> auth();
    void findDeviceById(Long deviceId);
}
