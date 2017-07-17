package com.netstatx.draco.core.device.contorller;

import com.netstatx.draco.core.device.model.Device;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@RestController
@RequestMapping("/api")
public class DeviceController extends BaseController {
    @PostMapping(value = "/devices")
    @ResponseBody
    public Device saveDevice(@RequestBody Device device) {
        device.doPreSave();
        return device;
    }
}
