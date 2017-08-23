package com.netstatx.draco.core.device.service;

import com.netstatx.draco.core.device.dao.ProductMessageTypeDao;
import com.netstatx.draco.core.device.model.ProductMessageTypeEntity;
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
public class ProductMessageTypeService {

    @Autowired
    private ProductMessageTypeDao msgTypeDao;

    public ProductMessageTypeEntity findProductMessageTypeById(Long msgTypeId) {
        return msgTypeDao.findOne(msgTypeId);
    }

    public List<ProductMessageTypeEntity> findByCondition(String tag, Long productId, String cat) {
        List<ProductMessageTypeEntity> resultList = null;
        Specification querySpecifi = new Specification<ProductMessageTypeEntity>() {
            @Override
            public Predicate toPredicate(Root<ProductMessageTypeEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (tag != null && !tag.trim().equals("")) {
                    predicates.add(criteriaBuilder.like(root.get("gatewayName"), "%" + tag + "%"));
                }
                if (cat != null && !cat.trim().equals("")) {
                    predicates.add(criteriaBuilder.equal(root.get("category"), cat));
                }
                if (productId != null && productId > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        return msgTypeDao.findAll(querySpecifi);
    }

    public ProductMessageTypeEntity saveProductMessageType(ProductMessageTypeEntity productMessageTypeEntity) {
        return msgTypeDao.save(productMessageTypeEntity);
    }

    public void deleteProductMessageType(Long id) {
        msgTypeDao.delete(id);
    }

}
