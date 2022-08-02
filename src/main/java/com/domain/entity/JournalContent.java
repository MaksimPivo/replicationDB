package com.domain.entity;

import com.domain.entity.common.AbstractEntity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "journal_content")
@AttributeOverride(name = "id", column = @Column(name = "journal_content_id"))
public class JournalContent extends AbstractEntity {

    @Column(name = "journal_header_id")
    private Long journalHeader;

    @Column(name = "student_id")
    private Long student;

    @Column(name = "presence")
    private Boolean presence;

    @Column(name = "lateness")
    private Short lateness;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "discription")
    private String discription;
}
