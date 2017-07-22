package com.netstatx.draco.core.telemetry.dao;

import com.netstatx.draco.core.telemetry.data.Packet;

import java.util.List;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public class CassandraPacketDao extends BaseCassandraDao implements PacketDao {
    @Override
    public List<Packet> find() {
        return null;
    }

    @Override
    public Packet findById(Long id) {
        return null;
    }

    @Override
    public Packet save(Packet packet) {
        return null;
    }

    @Override
    public boolean removeById(Long id) {
        return false;
    }
}
