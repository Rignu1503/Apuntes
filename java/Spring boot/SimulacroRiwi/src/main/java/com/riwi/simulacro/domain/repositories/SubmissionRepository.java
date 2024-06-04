package com.riwi.simulacro.domain.repositories;

import com.riwi.simulacro.domain.entities.Assignment;
import com.riwi.simulacro.domain.entities.Submission;
import com.riwi.simulacro.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {
    Page<Submission> findByAssignmentId(Assignment assignment, Pageable pageable);
    Page<Submission> findByUserId(User user, Pageable pageable);
}
