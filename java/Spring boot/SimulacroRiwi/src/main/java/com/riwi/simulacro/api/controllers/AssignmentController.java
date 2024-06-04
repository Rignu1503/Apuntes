package com.riwi.simulacro.api.controllers;

import com.riwi.simulacro.api.dto.request.create.AssignmentRequest;
import com.riwi.simulacro.api.dto.request.update.AssignmentUpdateRequest;
import com.riwi.simulacro.api.dto.response.AssignmentResponse;
import com.riwi.simulacro.infraestructure.abstract_services.IAssignmentService;
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
@RequestMapping("/assignments")
@AllArgsConstructor
public class AssignmentController {
    @Autowired
    private final IAssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<AssignmentResponse> saveAssignment(@Validated @RequestBody AssignmentRequest assignmentRequest) {
        return ResponseEntity.ok(assignmentService.create(assignmentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable Long id,
            @Validated @RequestBody AssignmentUpdateRequest assignmentRequest
    ) {
        return ResponseEntity.ok(assignmentService.update(id, assignmentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lessons/{lessonId}")
    public ResponseEntity<Page<AssignmentResponse>> getAllAssignments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable Long lessonId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(assignmentService.findByLessonId(pageable,lessonId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AssignmentResponse>> getAssignment(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentService.getById(id));
    }
}
