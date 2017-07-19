package com.netstatx.draco.core.telemetry.data;


import com.netstatx.draco.common.data.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@EqualsAndHashCode
public class Packet implements BaseData {
    private Long id;
}
