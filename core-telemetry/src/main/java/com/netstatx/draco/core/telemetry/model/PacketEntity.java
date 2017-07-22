package com.netstatx.draco.core.telemetry.model;

import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.netstatx.draco.core.telemetry.data.Packet;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(name = "packets")
public class PacketEntity extends BaseUuidEntity<Packet> {
    @PartitionKey(1)
    @Column
    private Long id;

    @ClusteringColumn(1)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "packet_name")
    private String packetName;

    @Column(name = "packet_index")
    private Integer packetIndex;

    @Column(name = "packet_key")
    private String packetKey;

    @Column(name = "status", codec = StatusCodec.class)
    private Status status;

    @Override
    public Packet toData() {
        return null;
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

    public static class StatusCodec extends EnumNameCodec<Status> {

        public StatusCodec() {
            super(Status.class);
        }
    }
}
