package com.netstatx.draco.core.telemetry.service.impl;

import com.netstatx.draco.core.telemetry.data.Field;
import com.netstatx.draco.core.telemetry.data.Packet;
import com.netstatx.draco.core.telemetry.service.PacketService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Component
public class PacketServiceImpl implements PacketService {
    @Override
    public Packet findPacketById(Long packetId) {
        return null;
    }

    @Override
    public Packet savePacket(Packet packet) {
        return null;
    }

    @Override
    public void deletePacket(Long packetId) {

    }

    @Override
    public int saveFieldList(List<Field> fieldList) {
        return 0;
    }

    @Override
    public Field saveField(Field field) {
        return null;
    }
}
