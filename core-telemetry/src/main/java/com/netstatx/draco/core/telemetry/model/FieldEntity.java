package com.netstatx.draco.core.telemetry.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.netstatx.draco.core.telemetry.data.Field;
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
@Table(name = "fields")
public class FieldEntity extends BaseUuidEntity<Field> {
    @PartitionKey
    @Column
    private Long id;

    @PartitionKey(value = 1)
    @Column(name = "packet_id")
    private String packetId;

    @Column(name = "field_id")
    private String fieldName;

    @Column(name = "field_index")
    private Integer fieldIndex;

    @Column(name = "field_key")
    private String fieldKey;

    @Override
    public Field toData() {
        return null;
    }
}
