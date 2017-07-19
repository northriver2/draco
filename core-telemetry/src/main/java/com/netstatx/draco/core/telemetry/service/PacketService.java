package com.netstatx.draco.core.telemetry.service;


import com.netstatx.draco.core.telemetry.model.Packet;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public interface PacketService {

    Packet findPacketById(Long packetId);

    Packet savePacket(Packet packet);

    void deletePacket(Long packetId);
}
