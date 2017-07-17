package com.netstatx.draco.snowflake.client;

import com.netstatx.draco.snowflake.api.gen.SnowflakeProtos;
import com.netstatx.draco.snowflake.api.gen.SnowflakeServiceGrpc;
import io.grpc.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * A java client to get uuid and next primary key
 *
 * @author wangle<thisiswangle@gmail.com>
 */
public class SnowflakeClient {
    private static final Logger LOG = LogManager.getLogger(SnowflakeClient.class);
    private final ManagedChannel channel;
    private final SnowflakeServiceGrpc.SnowflakeServiceBlockingStub blockingStub;

    public SnowflakeClient(String host, Integer port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build());
    }

    SnowflakeClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = SnowflakeServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public long getUUID() {
        SnowflakeProtos.Snowflake.EmptyRequest request = SnowflakeProtos.Snowflake.EmptyRequest.newBuilder()
                .build();
        try {
            return blockingStub.getUUID(request).getUuid();
        } catch (StatusRuntimeException e) {
            LOG.fatal("RPC failed: {}", e.getStatus(), e);
            throw new IllegalArgumentException("RPC failed:" + e.getStatus());
        }
    }
}
