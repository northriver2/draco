package com.netstatx.draco.core.device.service;

import com.netstatx.draco.core.device.dao.ProductAttributeDao;
import com.netstatx.draco.core.device.model.ProductAttributeEntity;
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
public class ProductAttributeService {

    @Autowired
    private ProductAttributeDao attributeDao;

    public ProductAttributeEntity findProductAttributeById(Long attributeId) {
        return attributeDao.findOne(attributeId);
    }

    public List<ProductAttributeEntity> findByCondition(String tag, Long productId, String packet) {
        List<ProductAttributeEntity> resultList = null;
        Specification querySpecifi = new Specification<ProductAttributeEntity>() {
            @Override
            public Predicate toPredicate(Root<ProductAttributeEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (tag != null && !tag.trim().equals("")) {
                    predicates.add(criteriaBuilder.like(root.get("gatewayName"), "%" + tag + "%"));
                }
                if (packet != null && !packet.trim().equals("")) {
                    predicates.add(criteriaBuilder.equal(root.get("packet"), packet));
                }
                if (productId != null && productId > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        return attributeDao.findAll(querySpecifi);
    }

    public ProductAttributeEntity saveProductAttribute(ProductAttributeEntity ProductAttributeEntity) {
        return attributeDao.save(ProductAttributeEntity);
    }

    public void deleteProductAttribute(Long id) {
        attributeDao.delete(id);
    }

}
