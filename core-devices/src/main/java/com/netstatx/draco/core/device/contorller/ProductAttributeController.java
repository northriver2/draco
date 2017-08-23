package com.netstatx.draco.core.device.contorller;

import com.netstatx.draco.core.device.model.ProductAttributeEntity;
import com.netstatx.draco.core.device.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author songwb<songwb@aliyun.com>
 */
@RestController
@RequestMapping("/api/product")
public class ProductAttributeController extends BaseController {

    @Autowired
    private ProductAttributeService attributeService;

    @RequestMapping(value = "/{id}/attribute/{aid}")
    @ResponseBody
    public ProductAttributeEntity getProductAttributeById(@PathVariable("id") Long id, @PathVariable("aid") Long aid) {
        return attributeService.findProductAttributeById(aid);
    }

    @RequestMapping(value = "/{id}/attribute")
    @ResponseBody
    public List<ProductAttributeEntity> queryProductAttribute(@RequestParam(value = "tag", required = false) String tag,
                                                              @PathVariable(value = "id") Long productId,
                                                              @RequestParam(value = "packet", required = false) String packet) {
        return attributeService.findByCondition(tag, productId, packet);
    }

    @PostMapping(value = "/{id}/attribute/add")
    public ProductAttributeEntity saveProductAttribute(@PathVariable("id") Long id, @RequestBody ProductAttributeEntity productAttributeEntity) {
        productAttributeEntity.doPreSave();
        productAttributeEntity.setProductId(id);
        return attributeService.saveProductAttribute(productAttributeEntity);
    }

    @RequestMapping("/{id}/attribute/{aid}/delete")
    public void deleteProductAttribute(@PathVariable("aid") Long aid) {
        ProductAttributeEntity gw = attributeService.findProductAttributeById(aid);
        if (gw != null) {
            gw.setEnabled(false);
            attributeService.saveProductAttribute(gw);
        }
        //attributeService.deleteProductAttribute();
    }

    @PostMapping("/{id}/attribute/{aid}/update")
    public ProductAttributeEntity updateProductAttribute(@PathVariable("aid") Long aid, ProductAttributeEntity productAttributeEntity) {
        productAttributeEntity.setId(aid);
        return attributeService.saveProductAttribute(productAttributeEntity);
    }

}
