package com.netstatx.draco.core.telemetry.service;


import com.netstatx.draco.core.telemetry.data.Field;
import com.netstatx.draco.core.telemetry.data.Packet;

import java.util.List;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface PacketService {

    Packet findPacketById(Long packetId);

    Packet savePacket(Packet packet);

    void deletePacket(Long packetId);

    /**
     * Save multi-fields at one api call
     * @param fieldList field object list
     * @return the count of the fields
     */
    int saveFieldList(List<Field> fieldList);

    Field saveField(Field field);
}
