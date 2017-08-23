package com.netstatx.draco.core.device.contorller;

import com.netstatx.draco.core.device.model.GatewayEntity;
import com.netstatx.draco.core.device.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author songwb<songwb@aliyun.com>
 */
@RestController
@RequestMapping("/api")
public class GatewayController extends BaseController {

    @Autowired
    private GatewayService gatewayService;

    @RequestMapping(value = "/gateway/{id}")
    @ResponseBody
    public GatewayEntity getGatewayById(@PathVariable("id") Long id) {
        return gatewayService.findGatewayById(id);
    }

    @RequestMapping(value = "/gateway")
    @ResponseBody
    public List<GatewayEntity> queryGateway(@RequestParam(value = "tag", required = false) String tag,
                                            @RequestParam(value = "product_id", required = false) Long productId,
                                            @RequestParam(value = "ip_address", required = false) String ipAddress) {
        return gatewayService.findByCondition(tag, productId, ipAddress);
    }

    @PostMapping(value = "/gateway/add")
    public GatewayEntity saveGateway(@RequestBody GatewayEntity GatewayEntity) {
        GatewayEntity.doPreSave();
        return gatewayService.saveGateway(GatewayEntity);
    }

    @RequestMapping("/gateway/{id}/delete")
    public void deleteGateway(@PathVariable("id") Long id) {
        GatewayEntity gw = gatewayService.findGatewayById(id);
        if (gw != null) {
            gw.setEnabled(false);
            gatewayService.saveGateway(gw);
        }
        //gatewayService.deleteGateway();
    }

    @PostMapping("/gateway/{id}/update")
    public GatewayEntity updateGateway(@PathVariable("id") Long id, GatewayEntity GatewayEntity) {
        GatewayEntity.setId(id);
        return gatewayService.saveGateway(GatewayEntity);
    }

    @RequestMapping("/gateway/{id}/topic")
    public List<String> findAllTopic(@PathVariable("id") Long id) {
        return gatewayService.findAllTopic(id);
    }

    @RequestMapping(value = "/gateway/{id}/validate")
    @ResponseBody
    public boolean validate(@PathVariable("id") Long id,
                            @RequestParam(value = "auth_key", required = false) String authKey,
                            @RequestParam(value = "auth_secret", required = false) String authSecret) {
        return gatewayService.validate(id, authKey, authSecret);
    }

}
