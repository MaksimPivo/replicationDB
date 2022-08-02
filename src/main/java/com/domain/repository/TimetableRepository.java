package com.domain.repository;

import com.domain.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
