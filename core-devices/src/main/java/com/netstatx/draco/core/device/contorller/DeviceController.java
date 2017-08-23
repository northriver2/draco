package com.netstatx.draco.core.device.contorller;

import com.netstatx.draco.core.device.model.DeviceEntity;
import com.netstatx.draco.core.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@RestController
@RequestMapping("/api")
public class DeviceController extends BaseController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/device/{id}")
    @ResponseBody
    public DeviceEntity getDeviceById(@PathVariable("id") Long id) {
        return deviceService.findDeviceById(id);
    }

    @RequestMapping(value = "/device")
    @ResponseBody
    public List<DeviceEntity> queryDevice(@RequestParam(value = "tag", required = false) String tag,
                                          @RequestParam(value = "product_id", required = false) Long productId,
                                          @RequestParam(value = "gateway_id", required = false) Long gatewayId) {
        return deviceService.findByCondition(tag, productId, gatewayId);
    }

    @RequestMapping(value = "/product/{id}/device")
    @ResponseBody
    public List<DeviceEntity> queryDeviceByProductId(@PathVariable("id") Long id) {
        return deviceService.findByCondition(null, id, 0L);
    }

    @RequestMapping(value = "/gateway/{id}/device")
    @ResponseBody
    public List<DeviceEntity> queryDeviceByGatewayId(@PathVariable("id") Long id) {
        return deviceService.findByCondition(null, 0L, id);
    }

    @PostMapping(value = "/device/add")
    public DeviceEntity saveDevice(@RequestBody DeviceEntity deviceEntity) {
        deviceEntity.doPreSave();
        return deviceService.saveDevice(deviceEntity);
    }

    @RequestMapping("/{id}/delete")
    public void deleteDevice(@PathVariable("id") Long id) {
        DeviceEntity device = deviceService.findDeviceById(id);
        if (device != null) {
            device.setEnabled(false);
            deviceService.saveDevice(device);
        }
        //deviceService.deleteDevice();
    }

    @PostMapping("/{id}/update")
    public DeviceEntity updateDevice(@PathVariable("id") Long id, DeviceEntity deviceEntity) {
        deviceEntity.setId(id);
        return deviceService.saveDevice(deviceEntity);
    }

    @RequestMapping("/device/{id}/topic")
    public List<String> findAllTopic(@PathVariable("id") Long id) {
        return deviceService.findAllTopic(id);
    }


}
