package com.netstatx.draco.core.telemetry.dao;

import com.datastax.driver.core.CodecRegistry;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.core.exceptions.CodecNotFoundException;
import com.netstatx.draco.core.telemetry.config.cassandra.CassandraCluster;
import com.netstatx.draco.core.telemetry.model.PacketEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public abstract class BaseCassandraDao {
    @Autowired
    protected CassandraCluster cluster;

    private Session session;

    private ConsistencyLevel defaultReadLevel;
    private ConsistencyLevel defaultWriteLevel;

    protected Session getSession() {
        if (session == null) {
            session = cluster.getSession();
            defaultReadLevel = cluster.getDefaultReadConsistencyLevel();
            defaultWriteLevel = cluster.getDefaultWriteConsistencyLevel();
            CodecRegistry registry = session.getCluster().getConfiguration().getCodecRegistry();
            registerCodecIfNotFound(registry, new PacketEntity.StatusCodec());
        }
        return session;
    }

    private void registerCodecIfNotFound(CodecRegistry registry, TypeCodec<?> codec) {
        try {
            registry.codecFor(codec.getCqlType(), codec.getJavaType());
        } catch (CodecNotFoundException e) {
            registry.register(codec);
        }
    }
}
