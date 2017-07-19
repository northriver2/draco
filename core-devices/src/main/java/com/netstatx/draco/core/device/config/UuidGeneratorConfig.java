package com.netstatx.draco.core.device.config;

import com.netstatx.draco.snowflake.client.SnowflakeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Component
public class UuidGenerator {
    private static ApplicationContext CONTEXT;

    @Autowired
    public UuidGenerator(ApplicationContext context) {
        CONTEXT = context;
    }

    public static ApplicationContext getContext() {
        return CONTEXT;
    }

    public static Long getUUID() {
        return getContext().getBean(SnowflakeClient.class).getUUID();
    }
}
