package com.domain.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Status status = Status.ACTIVE;
    @CreatedDate
    @Column(name = "created")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDate created;
    @LastModifiedDate
    @Column(name = "updated")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDate updated;
}
