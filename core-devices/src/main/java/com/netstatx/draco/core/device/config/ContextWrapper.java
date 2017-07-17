package com.netstatx.draco.core.device.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Component
public class ContextWrapper {
    private static ApplicationContext CONTEXT;

    @Autowired
    public ContextWrapper(ApplicationContext context) {
        CONTEXT = context;
    }

    public static ApplicationContext getContext() {
        return CONTEXT;
    }
}
