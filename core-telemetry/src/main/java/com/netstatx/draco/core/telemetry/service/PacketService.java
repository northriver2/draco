package com.netstatx.draco.core.telemetry.service;


import com.netstatx.draco.core.telemetry.model.PacketEntity;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface PacketService {

    PacketEntity findPacketById(Long packetId);

    PacketEntity savePacket(PacketEntity packetEntity);

    void deletePacket(Long packetId);
}
