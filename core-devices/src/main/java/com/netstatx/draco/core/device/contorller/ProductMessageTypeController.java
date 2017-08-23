package com.netstatx.draco.core.device.contorller;

import com.netstatx.draco.core.device.model.ProductMessageTypeEntity;
import com.netstatx.draco.core.device.service.ProductMessageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author songwb<songwb@aliyun.com>
 */
@RestController
@RequestMapping("/api/product")
public class ProductMessageTypeController extends BaseController {

    @Autowired
    private ProductMessageTypeService msgService;

    @RequestMapping(value = "/{id}/message_type/{aid}")
    @ResponseBody
    public ProductMessageTypeEntity getProductMessageTypeById(@PathVariable("id") Long id, @PathVariable("aid") Long aid) {
        return msgService.findProductMessageTypeById(aid);
    }

    @RequestMapping(value = "/{id}/message_type")
    @ResponseBody
    public List<ProductMessageTypeEntity> queryProductMessageType(@RequestParam(value = "tag", required = false) String tag,
                                                                  @PathVariable(value = "id") Long productId,
                                                                  @RequestParam(value = "category", required = false) String packet) {
        return msgService.findByCondition(tag, productId, packet);
    }

    @PostMapping(value = "/{id}/message_type/add")
    public ProductMessageTypeEntity saveProductMessageType(@PathVariable("id") Long id, @RequestBody ProductMessageTypeEntity msgEntity) {
        msgEntity.doPreSave();
        msgEntity.setProductId(id);
        return msgService.saveProductMessageType(msgEntity);
    }

    @RequestMapping("/{id}/message_type/{aid}/delete")
    public void deleteProductMessageType(@PathVariable("aid") Long aid) {
        ProductMessageTypeEntity gw = msgService.findProductMessageTypeById(aid);
        if (gw != null) {
            gw.setEnabled(false);
            msgService.saveProductMessageType(gw);
        }
        //msgService.deleteProductMessageType();
    }

    @PostMapping("/{id}/message_type/{aid}/update")
    public ProductMessageTypeEntity updateProductMessageType(@PathVariable("aid") Long aid, ProductMessageTypeEntity msgEntity) {
        msgEntity.setId(aid);
        return msgService.saveProductMessageType(msgEntity);
    }

}
