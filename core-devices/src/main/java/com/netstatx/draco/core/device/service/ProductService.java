package com.netstatx.draco.core.device.service;

import com.netstatx.draco.core.device.dao.ProductDao;
import com.netstatx.draco.core.device.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songwb<songwb@aliyun.com>
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public ProductEntity findProductById(Long id) {
        return productDao.findOne(id);
    }

    public List<ProductEntity> findByCondition(String tag) {
        List<ProductEntity> resultList = null;
        Specification querySpecifi = new Specification<ProductEntity>() {
            @Override
            public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (tag != null && !tag.trim().equals("")) {
                    predicates.add(criteriaBuilder.like(root.get("gatewayName"), "%" + tag + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        return productDao.findAll(querySpecifi);
    }

    public ProductEntity saveProduct(ProductEntity ProductEntity) {
        return productDao.save(ProductEntity);
    }

    public void deleteProduct(Long id) {
        productDao.delete(id);
    }

}
