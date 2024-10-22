package com.riwi.simulacro.infraestructure.services;

import com.riwi.simulacro.api.dto.request.create.AssignmentRequest;
import com.riwi.simulacro.api.dto.request.update.AssignmentUpdateRequest;
import com.riwi.simulacro.api.dto.response.AssignmentResponse;
import com.riwi.simulacro.domain.entities.Assignment;
import com.riwi.simulacro.domain.entities.Lesson;
import com.riwi.simulacro.domain.repositories.AssignmentRepository;
import com.riwi.simulacro.domain.repositories.LessonRepository;
import com.riwi.simulacro.infraestructure.abstract_services.IAssignmentService;
import com.riwi.simulacro.infraestructure.mappers.AssignmentMapper;
import com.riwi.simulacro.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AssignmentService implements IAssignmentService {

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Autowired
    private final AssignmentMapper assignmentMapper;

    @Autowired
    private final LessonRepository lessonRepository;

    @Override
    public AssignmentResponse create(AssignmentRequest assignmentRequest) {
        Assignment assignment = assignmentMapper.toAssignment(assignmentRequest);
        Lesson lesson = lessonRepository.findById(assignmentRequest.getLessonId())
                .orElseThrow(() -> new IdNotFoundException("LESSON", assignmentRequest.getLessonId()));

        assignment.setLessonId(lesson);
        Assignment saveAssignment = assignmentRepository.save(assignment);
        return assignmentMapper.toAssignmentResponse(saveAssignment);
    }

    @Override
    public AssignmentResponse update(Long id, AssignmentUpdateRequest assignmentRequest) {
        Assignment existingAssignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ASSIGNMENT", id));

        assignmentMapper.updateFromAssignmentRequest(assignmentRequest, existingAssignment);
        Assignment updateAssignment = assignmentRepository.save(existingAssignment);
        return assignmentMapper.toAssignmentResponse(updateAssignment);
    }

    @Override
    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public Page<AssignmentResponse> getAll(Pageable pageable) {
        Page<Assignment> assignmentPage = assignmentRepository.findAll(pageable);
        return assignmentPage.map(assignmentMapper::toAssignmentResponse);
    }

    @Override
    public Optional<AssignmentResponse> getById(Long id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        if (assignment.isEmpty()) throw new IdNotFoundException("ASSIGNMENT", id);
        return assignment.map(assignmentMapper::toAssignmentResponse);
    }

    @Override
    public Page<AssignmentResponse> findByLessonId(Pageable pageable, Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new IdNotFoundException("LESSON", lessonId));

        Page<Assignment> assignmentPage = assignmentRepository.findByLessonId(lesson, pageable);
        return assignmentPage.map(assignmentMapper::toAssignmentResponse);
    }
}
