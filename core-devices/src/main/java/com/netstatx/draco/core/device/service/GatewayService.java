package com.netstatx.draco.core.device.service;

import com.netstatx.draco.core.device.dao.GatewayDao;
import com.netstatx.draco.core.device.model.GatewayEntity;
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
public class GatewayService {

    @Autowired
    private GatewayDao gatewayDao;
    @Autowired
    private ProductMessageTypeService msgService;

    public GatewayEntity findGatewayById(Long gatewayId) {
        return gatewayDao.findOne(gatewayId);
    }

    public List<GatewayEntity> findByCondition(String tag, Long productId, String ipAddress) {
        List<GatewayEntity> resultList = null;
        Specification querySpecifi = new Specification<GatewayEntity>() {
            @Override
            public Predicate toPredicate(Root<GatewayEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (tag != null && !tag.trim().equals("")) {
                    predicates.add(criteriaBuilder.like(root.get("gatewayName"), "%" + tag + "%"));
                }
                if (ipAddress != null && !ipAddress.trim().equals("")) {
                    predicates.add(criteriaBuilder.equal(root.get("ipAddress"), ipAddress));
                }
                if (productId != null && productId > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        return gatewayDao.findAll(querySpecifi);
    }

    public GatewayEntity saveGateway(GatewayEntity GatewayEntity) {
        return gatewayDao.save(GatewayEntity);
    }

    public void deleteGateway(Long id) {
        gatewayDao.delete(id);
    }

    public boolean validate(Long id, String authKey, String authSecret) {
        GatewayEntity de = findGatewayById(id);
        return de.getGatewayKey() == authKey && de.getGatewaySecret() == authSecret;
    }

    public List<String> findAllTopic(Long id) {
        GatewayEntity de = findGatewayById(id);
        List<ProductMessageTypeEntity> lstM = msgService.findByCondition(null, de.getProductId(), null);
        if (lstM != null && lstM.size() > 0) {
            List<String> ret = new ArrayList<>();
            for (ProductMessageTypeEntity me : lstM) {
                ret.add(de.getId() + "/" + me.getMessageCode());
            }
            return ret;
        }
        return null;
    }
}
