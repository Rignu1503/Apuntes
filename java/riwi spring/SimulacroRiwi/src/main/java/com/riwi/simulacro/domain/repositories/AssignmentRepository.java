package com.riwi.simulacro.domain.repositories;

import com.riwi.simulacro.domain.entities.Assignment;
import com.riwi.simulacro.domain.entities.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    Page<Assignment> findByLessonId(Lesson lesson,Pageable pageable);
}
