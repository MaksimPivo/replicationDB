package com.domain.entity;

import com.domain.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "type_class")
@AttributeOverride(name = "id", column = @Column(name = "type_class_id"))
public class TypeClass extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "id_from_source")
    private Long idFromSource;
}
