package com.netstatx.draco.snowflake.server;

import com.netstatx.draco.snowflake.api.gen.SnowflakeProtos;
import com.netstatx.draco.snowflake.api.gen.SnowflakeServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public class SnowflakeService extends SnowflakeServiceGrpc.SnowflakeServiceImplBase {
    private final AtomicLong serialNumber = new AtomicLong(0);

    @Override
    public void getUUID(SnowflakeProtos.Snowflake.EmptyRequest request, StreamObserver<SnowflakeProtos.Snowflake.UUID> responseObserver) {
        // 2017-07-01T00:00:00.000+0800"
        long epoch =1498838400000L;
        int workerId = getWorkerId(), serialNumberBits = 12;
        int maxSerialNumber = 0x01 << serialNumberBits;
        int serialNumber = (int) (this.serialNumber.incrementAndGet() % maxSerialNumber);
        long now = System.currentTimeMillis();

        long uuid = (now - epoch) << 22;
        uuid |= (workerId << serialNumberBits);
        uuid |= serialNumber;

        SnowflakeProtos.Snowflake.UUID value = SnowflakeProtos.Snowflake.UUID.newBuilder()
                .setUuid(uuid)
                .build();

        responseObserver.onNext(value);
        responseObserver.onCompleted();
    }

    private int getWorkerId() {
        String workerId = System.getenv("WORKER_ID");
        return Integer.parseInt(Optional.ofNullable(workerId).orElse("0"));
    }
}

