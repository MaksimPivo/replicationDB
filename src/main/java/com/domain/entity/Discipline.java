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
@Table(name = "discipline")
@AttributeOverride(name = "id", column = @Column(name = "discipline_id"))
public class Discipline extends AbstractEntity {

    @Column(name = "short_name")
    private String name;

    @Column(name = "id_from_source")
    private Long idFromSource;
}
