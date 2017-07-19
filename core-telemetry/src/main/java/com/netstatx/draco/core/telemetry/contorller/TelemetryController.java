package com.netstatx.draco.core.telemetry.contorller;

import com.google.common.collect.Lists;
import com.netstatx.draco.core.telemetry.data.Field;
import com.netstatx.draco.core.telemetry.data.Packet;
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
        return Lists.newArrayList();
    }

    @PostMapping(path = "/packets")
    public Packet createPacket(@RequestBody Packet packet) {
        return this.packetService.savePacket(packet);
    }

    @PostMapping(path = "/packets/{packetId}/fields")
    public int createField(@PathVariable Long packetId, @RequestBody List<Field> fieldList) {
        Packet packet = packetService.findPacketById(packetId);
        fieldList.forEach(field -> field.setPacketId(packet.getId()));
        return this.packetService.saveFieldList(fieldList);
    }
}
