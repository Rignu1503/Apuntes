package com.riwi.simulacro.api.controllers;

import com.riwi.simulacro.api.dto.request.create.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.EnrollmentResponse;
import com.riwi.simulacro.infraestructure.abstract_services.IEnrollmentService;
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
@RequestMapping("/enrollments")
@AllArgsConstructor
public class EnrollmentController {
    @Autowired
    private final IEnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> saveEnrollment(@Validated @RequestBody EnrollmentRequest enrollmentRequest) {
        return ResponseEntity.ok(enrollmentService.create(enrollmentRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Page<EnrollmentResponse>> getAllEnrollmentsByUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable Long userId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(enrollmentService.findByUserId(userId, pageable));
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Page<EnrollmentResponse>> getAllEnrollmentsByCourse(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable Long courseId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(enrollmentService.findByCourseId(courseId, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EnrollmentResponse>> getEnrollment(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getById(id));
    }
}
