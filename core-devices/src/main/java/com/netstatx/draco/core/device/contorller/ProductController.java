package com.netstatx.draco.core.device.contorller;

import com.netstatx.draco.core.device.model.ProductEntity;
import com.netstatx.draco.core.device.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author songwb<songwb@aliyun.com>
 */
@RestController
@RequestMapping("/api")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/{id}")
    @ResponseBody
    public ProductEntity getProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @RequestMapping(value = "/product")
    @ResponseBody
    public List<ProductEntity> queryProduct(@RequestParam(value = "tag", required = false) String tag) {
        return productService.findByCondition(tag);
    }

    @PostMapping(value = "/product/add")
    public ProductEntity saveProduct(@RequestBody ProductEntity ProductEntity) {
        ProductEntity.doPreSave();
        return productService.saveProduct(ProductEntity);
    }

    @RequestMapping("/product/{id}/delete")
    public void deleteProduct(@PathVariable("id") Long id) {
        ProductEntity gw = productService.findProductById(id);
        if (gw != null) {
            gw.setEnabled(false);
            productService.saveProduct(gw);
        }
        //productService.deleteProduct();
    }

    @PostMapping("/product/{id}/update")
    public ProductEntity updateProduct(@PathVariable("id") Long id, ProductEntity ProductEntity) {
        ProductEntity.setId(id);
        return productService.saveProduct(ProductEntity);
    }

}
