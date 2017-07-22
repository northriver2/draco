package com.netstatx.draco.core.telemetry.model;

import com.netstatx.draco.core.telemetry.data.Field;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(
        name = "fields",
        uniqueConstraints = {
                @UniqueConstraint(columnNames={"packet_id", "fieldIndex"}),
                @UniqueConstraint(columnNames={"packet_id", "fieldKey"}),
        }
)
public class FieldEntity extends BaseUuidEntity<Field> {
    @Id
    private Long id;

    @Column(name = "packet_id", nullable = false)
    private String packetId;

    @Column(name = "field_id", nullable = false)
    private String fieldName;

    @Column(name = "field_index", nullable = false)
    private Integer fieldIndex;

    @Column(name = "field_key", nullable = false)
    private String fieldKey;

    @Override
    public Field toData() {
        return null;
    }
}
