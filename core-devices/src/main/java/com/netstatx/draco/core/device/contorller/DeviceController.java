package com.netstatx.draco.core.device.contorller;

import com.netstatx.draco.core.device.model.DeviceEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@RestController
@RequestMapping("/api")
public class DeviceController extends BaseController {
    @PostMapping(value = "/devices")
    public DeviceEntity saveDevice(@RequestBody DeviceEntity deviceEntity) {
        deviceEntity.doPreSave();
        return deviceEntity;
    }
}
