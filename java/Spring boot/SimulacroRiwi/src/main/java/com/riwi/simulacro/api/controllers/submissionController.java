package com.riwi.simulacro.api.controllers;

import com.riwi.simulacro.api.dto.request.create.SubmissionRequest;
import com.riwi.simulacro.api.dto.request.update.SubmissionUpdateRequest;
import com.riwi.simulacro.api.dto.response.SubmissionResponse;
import com.riwi.simulacro.infraestructure.abstract_services.ISubmissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/submissions")
@AllArgsConstructor
public class submissionController {
    @Autowired
    private final ISubmissionService submissionService;

    @PostMapping
    public ResponseEntity<SubmissionResponse> saveSubmission(@Validated @RequestBody SubmissionRequest submissionRequest) {
        return ResponseEntity.ok(submissionService.create(submissionRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubmissionResponse> updateSubmission(
            @PathVariable Long id,
            @Validated @RequestBody SubmissionUpdateRequest submissionRequest
    ) {
        return ResponseEntity.ok(submissionService.update(id, submissionRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        submissionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SubmissionResponse>> getSubmission(@PathVariable Long id) {
        return ResponseEntity.ok(submissionService.getById(id));
    }

    @GetMapping("/assignments/{assignmentId}")
    public ResponseEntity<Page<SubmissionResponse>> getAllSubmissionsByAssignment(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable Long assignmentId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(submissionService.findByAssignmentId(pageable,assignmentId));
    }

    @GetMapping("/users/{UserId}")
    public ResponseEntity<Page<SubmissionResponse>> getAllSubmissionsByUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable Long UserId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(submissionService.findByUserId(pageable,UserId));
    }
}
