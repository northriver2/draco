package com.netstatx.draco.core.telemetry.contorller;

import com.netstatx.draco.core.telemetry.service.PacketService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
public abstract class BaseController {
    @Autowired
    PacketService packetService;
}
