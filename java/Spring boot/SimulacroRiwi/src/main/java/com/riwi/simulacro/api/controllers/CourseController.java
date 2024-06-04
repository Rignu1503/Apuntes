package com.riwi.simulacro.api.controllers;

import com.riwi.simulacro.api.dto.request.create.CourseRequest;
import com.riwi.simulacro.api.dto.request.update.CourseUpdateRequest;
import com.riwi.simulacro.api.dto.response.CourseResponse;
import com.riwi.simulacro.infraestructure.abstract_services.ICourseService;
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
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {

    @Autowired
    private final ICourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponse> saveCourse(@Validated @RequestBody CourseRequest courseRequest) {
        return ResponseEntity.ok(courseService.create(courseRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> updateCourse(
            @PathVariable Long id,
            @Validated @RequestBody CourseUpdateRequest courseRequest
    ) {
        return ResponseEntity.ok(courseService.update(id, courseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(courseService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CourseResponse>> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }
}
