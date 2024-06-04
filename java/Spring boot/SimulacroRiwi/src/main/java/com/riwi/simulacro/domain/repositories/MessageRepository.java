package com.riwi.simulacro.domain.repositories;

import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.Message;
import com.riwi.simulacro.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    Page<Message> findByCourseId(Course course, Pageable pageable);
    Page<Message> findBySenderIdAndReceiverId(User sender, User receiver, Pageable pageable);

}
