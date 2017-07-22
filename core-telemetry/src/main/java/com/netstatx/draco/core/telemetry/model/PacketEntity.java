package com.netstatx.draco.core.telemetry.model;

import com.netstatx.draco.core.telemetry.data.Packet;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(
        name = "packets",
        uniqueConstraints = {
                @UniqueConstraint(columnNames={"product_id", "packetIndex"}),
                @UniqueConstraint(columnNames={"product_id", "packetKey"}),
        }
)
public class PacketEntity extends BaseUuidEntity<Packet> {
    @Id
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "packet_name", nullable = false)
    private String packetName;

    @Column(name = "packet_index", nullable = false)
    private Integer packetIndex;

    @Column(name = "packet_key", nullable = false)
    private String packetKey;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ACTIVE','INACTIVE') DEFAULT 'ACTIVE'", nullable = false)
    private Status status;

    @Override
    public Packet toData() {
        return null;
    }

    public enum Status {
        ACTIVE, INACTIVE
    }
}
