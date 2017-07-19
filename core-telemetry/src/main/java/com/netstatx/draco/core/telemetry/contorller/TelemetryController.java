package com.netstatx.draco.core.telemetry.contorller;

import com.netstatx.draco.core.telemetry.model.Packet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@RestController
@RequestMapping("/api")
public class TelemetryController extends BaseController {
    @GetMapping(path = "/devices/{devicesId}/telemetry")
    public List getTelemetryByDeviceId(Long deviceId) {
        return null;
    }

    @PostMapping(path = "/packets")
    public void createPacket(@RequestBody Packet packet) {
    }
}
