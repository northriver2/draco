package com.netstatx.draco.snowflake.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

/**
 * Algorithm:
 *
 * +-------------------------------------------------------------------------------------------------+
 * | UNUSED(1BIT) |         TIMESTAMP(41BIT)           |  WORKER-ID(10BIT)  |    SERIAL-NO(12BIT)    |
 * +-------------------------------------------------------------------------------------------------+
 *
 * @author wangle<thisiswangle@gmail.com>
 */
@Log4j2
public class SnowflakeServer {
    private final Integer port;
    private final Server server;

    public SnowflakeServer(Integer port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port).addService(new SnowflakeService()).build();
    }

    /** Start serving requests. */
    public void start() throws IOException, InterruptedException {
        server.start();
        log.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may has been reset by its JVM shutdown hook.
            log.info("*** shutting down gRPC server since JVM is shutting down");
            SnowflakeServer.this.stop();
            log.info("*** server shut down");
        }));

        this.blockUntilShutdown();
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
