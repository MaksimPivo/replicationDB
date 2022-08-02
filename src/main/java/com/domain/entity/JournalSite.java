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
@Table(name = "journal_site")
@AttributeOverride(name = "id", column = @Column(name = "journal_site_id"))
public class JournalSite extends AbstractEntity {

    @Column(name = "discipline_id")
    private Long discipline;

    @Column(name = "teacher_id")
    private Long teacher;

    @Column(name = "group_id")
    private Long group;

    @Column(name = "stream_id")
    private Integer streamId;

    @Column(name = "pattent_id_from_source")
    private Long pattentIdFromSource;
}
