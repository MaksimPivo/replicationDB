package com.domain.entity;

import com.domain.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "student")
@AttributeOverride(name = "id", column = @Column(name = "student_id"))
public class Student extends AbstractEntity {

    @Column(name = "group_id")
    private Long group;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "sub_group_id")
    private Integer subGroup;

    @Column(name = "id_from_source")
    private Long idFromSource;
}
