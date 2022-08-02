package com.domain.entity;

import com.domain.entity.common.AbstractEntity;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "journal_header")
@AttributeOverride(name = "id", column = @Column(name = "journal_header_id"))
public class JournalHeader extends AbstractEntity {

    @Column(name = "type_class_id")
    private Long typeClass;

    @Column(name = "journal_site_id")
    private Long journalSite;

    @Column(name = "sub_group")
    private Integer subGroup;

    @Column(name = "class_topic")
    private String classTopic;

    @Column(name = "replacement_teacher_id")
    private Long teacher;

    @Column(name = "discription")
    private String discription;

    @Column(name = "date_of_lesson")
    private LocalDate dateOfLesson;

    @Column(name = "hours_count")
    private Integer hoursCount;
}
