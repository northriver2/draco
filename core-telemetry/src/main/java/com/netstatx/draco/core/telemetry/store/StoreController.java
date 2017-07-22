package com.netstatx.draco.core.telemetry.store;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@RestController
@RequestMapping("/api")
public class StoreController extends BaseController {
    @GetMapping(path = "/devices/{devicesId}/telemetry")
    public List getTelemetryByDeviceId(Long deviceId) {
        return Lists.newArrayList();
    }
}
