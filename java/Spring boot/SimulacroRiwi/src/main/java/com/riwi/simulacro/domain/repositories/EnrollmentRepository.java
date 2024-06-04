package com.riwi.simulacro.domain.repositories;

import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.Enrollment;
import com.riwi.simulacro.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    Page<Enrollment> findByUserId(User user, Pageable pageable);
    Page<Enrollment> findByCourseId(Course course, Pageable pageable);
}
