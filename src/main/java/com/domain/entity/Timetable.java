package com.domain.entity;

import com.domain.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "pattern")
@AttributeOverride(name = "id", column = @Column(name = "pattern_id"))
public class Timetable extends AbstractEntity {

    @Column(name = "lesson_day")
    private String lessonDay;

    @Column(name = "discipline_name")
    private String disciplineName;

    @Column(name = "numerator")
    private Boolean numerator;

    @Column(name = "week_number")
    private Integer weekNumber;

    @Column(name = "lesson_number")
    private Integer lessonNumber;

    @Column(name = "type_class_name")
    private String typeClassName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "sub_group")
    private Integer subGroup;

    @Column(name = "frame")
    private String frame;

    @Column(name = "location")
    private String location;

    @Column(name = "teacher_fio")
    private String teacherFio;
}