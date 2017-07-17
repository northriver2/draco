package com.netstatx.draco.snowflake.server;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Configuration
@Log4j2
public class SnowflakeServerConfig {
    @Value("${snowflake.port}")
    private Integer port;

    @PostConstruct
    public void start() throws Exception {
        Thread awaitThread = new Thread(() -> {
            SnowflakeServer server = new SnowflakeServer(this.port);
            try {
                server.start();
            } catch (Exception e) {
                log.error("Snowflake server stopped.", e);
            }
        });
        awaitThread.setName("snowflake");
        awaitThread.setDaemon(false);
        awaitThread.start();
    }
}
