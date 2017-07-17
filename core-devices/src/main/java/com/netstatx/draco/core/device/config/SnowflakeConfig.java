package com.netstatx.draco.core.device.config;

import com.netstatx.draco.snowflake.client.SnowflakeClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Configuration
public class SnowflakeConfig {
    @Bean
    SnowflakeClient snowflakeClient(DiscoveryClient discoveryClient) {
        return discoveryClient.getInstances("snowflake")
                .stream().map(serviceInstance -> {
                    String host = serviceInstance.getHost();
                    int port = Integer.parseInt(serviceInstance.getMetadata().get("snowflake.port"));
                    return new SnowflakeClient(host, port);
                }).collect(Collectors.toList()).get(0);
    }
}
