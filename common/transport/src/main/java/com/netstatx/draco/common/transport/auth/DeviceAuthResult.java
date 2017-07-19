package com.netstatx.draco.common.data.auth;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
final public class DeviceAuthResult<T> {
    private final Boolean success;
    private final Long deviceId;
    private final T errorMsg;

    public static DeviceAuthResult of(Long deviceId) {
        return new DeviceAuthResult<>(true, deviceId, null);
    }

    public static <T> DeviceAuthResult of(T errorMsg) {
        return new DeviceAuthResult<>(false, null, errorMsg);
    }

    private DeviceAuthResult(Boolean success, Long deviceId, T errorMsg) {
        this.success = success;
        this.deviceId = deviceId;
        this.errorMsg = errorMsg;
    }

    public Boolean success() {
        return success;
    }

    public Long deviceId() {
        return deviceId;
    }

    public T errorMsg() {
        return errorMsg;
    }
}
