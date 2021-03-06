package com.netstatx.draco.core.device.service;

import com.netstatx.draco.core.device.dao.DeviceDao;
import com.netstatx.draco.core.device.model.DeviceEntity;
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
 * @author wangle<thisiswangle@gmail.com>
 */
@Service
public class DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private ProductMessageTypeService msgService;

    public DeviceEntity findDeviceById(Long deviceId) {
        return deviceDao.findOne(deviceId);
    }

    public List<DeviceEntity> findByCondition(String tag, Long productId, Long gatewayId) {
        List<DeviceEntity> resultList = null;
        Specification querySpecifi = new Specification<DeviceEntity>() {
            @Override
            public Predicate toPredicate(Root<DeviceEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (tag != null && !tag.trim().equals("")) {
                    predicates.add(criteriaBuilder.like(root.get("deviceName"), "%" + tag + "%"));
                }
                if (gatewayId != null && gatewayId > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("gatewayId"), gatewayId));
                }
                if (productId != null && productId > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("productId"), productId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        return deviceDao.findAll(querySpecifi);
    }

    public DeviceEntity saveDevice(DeviceEntity deviceEntity) {
        return deviceDao.save(deviceEntity);
    }

    public void deleteDevice(Long id) {
        deviceDao.delete(id);
    }

    public List<String> findAllTopic(Long id) {
        DeviceEntity de = findDeviceById(id);
        List<ProductMessageTypeEntity> lstM = msgService.findByCondition(null, de.getProductId(), null);
        if (lstM != null && lstM.size() > 0) {
            List<String> ret = new ArrayList<>();
            for (ProductMessageTypeEntity me : lstM) {
                ret.add(de.getGatewayId() + "/" + de.getProductId() + "/" + de.getId() + "/" + me.getMessageCode());
            }
            return ret;
        }
        return null;
    }
}
