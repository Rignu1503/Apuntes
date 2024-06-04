package com.riwi.simulacro.infraestructure.services;

import com.riwi.simulacro.api.dto.request.create.SubmissionRequest;
import com.riwi.simulacro.api.dto.request.update.SubmissionUpdateRequest;
import com.riwi.simulacro.api.dto.response.SubmissionResponse;
import com.riwi.simulacro.domain.entities.Assignment;
import com.riwi.simulacro.domain.entities.Submission;
import com.riwi.simulacro.domain.entities.User;
import com.riwi.simulacro.domain.repositories.AssignmentRepository;
import com.riwi.simulacro.domain.repositories.SubmissionRepository;
import com.riwi.simulacro.domain.repositories.UserRepository;
import com.riwi.simulacro.infraestructure.abstract_services.ISubmissionService;
import com.riwi.simulacro.infraestructure.mappers.SubmissionMapper;
import com.riwi.simulacro.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SubmissionService implements ISubmissionService {

    @Autowired
    private final SubmissionRepository submissionRepository;

    @Autowired
    private final SubmissionMapper submissionMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Override
    public SubmissionResponse create(SubmissionRequest submissionRequest) {
        Submission submission = submissionMapper.toSubmission(submissionRequest);
        User user = userRepository.findById(submissionRequest.getUserId())
                .orElseThrow(() -> new IdNotFoundException("USER", submissionRequest.getUserId()));
        Assignment assignment = assignmentRepository.findById(submissionRequest.getAssignmentId())
                .orElseThrow(() -> new IdNotFoundException("COURSE", submissionRequest.getAssignmentId()));

        submission.setUserId(user);
        submission.setAssignmentId(assignment);
        Submission saveSubmission = submissionRepository.save(submission);
        return submissionMapper.toSubmissionResponse(saveSubmission);
    }

    @Override
    public SubmissionResponse update(Long id, SubmissionUpdateRequest submissionRequest) {
        Submission existingSubmission = submissionRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ENROLLMENT", id));

        submissionMapper.updateFromSubmissionRequest(submissionRequest, existingSubmission);
        Submission updateSubmission = submissionRepository.save(existingSubmission);
        return submissionMapper.toSubmissionResponse(updateSubmission);
    }

    @Override
    public void delete(Long uuid) {
        submissionRepository.deleteById(uuid);
    }

    @Override
    public Page<SubmissionResponse> getAll(Pageable pageable) {
        Page<Submission> submissionPage = submissionRepository.findAll(pageable);
        return submissionPage.map(submissionMapper::toSubmissionResponse);
    }

    @Override
    public Optional<SubmissionResponse> getById(Long uuid) {
        Optional<Submission> submission = submissionRepository.findById(uuid);
        if (submission.isEmpty()) throw new IdNotFoundException("ENROLLMENT", uuid);
        return submission.map(submissionMapper::toSubmissionResponse);
    }

    @Override
    public Page<SubmissionResponse> findByAssignmentId(Pageable pageable, Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new IdNotFoundException("COURSE", assignmentId));
        Page<Submission> submissionPage = submissionRepository.findByAssignmentId(assignment, pageable);
        return submissionPage.map(submissionMapper::toSubmissionResponse);
    }

    @Override
    public Page<SubmissionResponse> findByUserId(Pageable pageable, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IdNotFoundException("USER", userId));
        Page<Submission> submissionPage = submissionRepository.findByUserId(user, pageable);
        return submissionPage.map(submissionMapper::toSubmissionResponse);
    }
}
