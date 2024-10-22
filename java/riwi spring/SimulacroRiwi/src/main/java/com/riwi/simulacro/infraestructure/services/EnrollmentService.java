package com.riwi.simulacro.infraestructure.services;

import com.riwi.simulacro.api.dto.request.create.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.EnrollmentResponse;
import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.Enrollment;
import com.riwi.simulacro.domain.entities.User;
import com.riwi.simulacro.domain.repositories.CourseRepository;
import com.riwi.simulacro.domain.repositories.EnrollmentRepository;
import com.riwi.simulacro.domain.repositories.UserRepository;
import com.riwi.simulacro.infraestructure.abstract_services.IEnrollmentService;
import com.riwi.simulacro.infraestructure.mappers.EnrollmentMapper;
import com.riwi.simulacro.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EnrollmentService implements IEnrollmentService {
    @Autowired
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    private final EnrollmentMapper enrollmentMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public EnrollmentResponse create(EnrollmentRequest enrollmentRequest) {
        Enrollment enrollment = enrollmentMapper.toEnrollment(enrollmentRequest);
        User user = userRepository.findById(enrollmentRequest.getUserId())
                .orElseThrow(() -> new IdNotFoundException("USER", enrollmentRequest.getUserId()));
        Course course = courseRepository.findById(enrollmentRequest.getCourseId())
                .orElseThrow(() -> new IdNotFoundException("COURSE", enrollmentRequest.getCourseId()));

        enrollment.setUserId(user);
        enrollment.setCourseId(course);
        Enrollment saveEnrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toEnrollmentResponse(saveEnrollment);
    }

    @Override
    public void delete(Long uuid) {
        enrollmentRepository.deleteById(uuid);
    }

    @Override
    public Page<EnrollmentResponse> getAll(Pageable pageable) {
        Page<Enrollment> enrollmentPage = enrollmentRepository.findAll(pageable);
        return enrollmentPage.map(enrollmentMapper::toEnrollmentResponse);
    }

    @Override
    public Optional<EnrollmentResponse> getById(Long uuid) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(uuid);
        if (enrollment.isEmpty()) throw new IdNotFoundException("ENROLLMENT", uuid);
        return enrollment.map(enrollmentMapper::toEnrollmentResponse);
    }

    @Override
    public Page<EnrollmentResponse> findByUserId(Long userId, Pageable pageable) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IdNotFoundException("USER", userId));
        Page<Enrollment> enrollmentPage = enrollmentRepository.findByUserId(user, pageable);
        return enrollmentPage.map(enrollmentMapper::toEnrollmentResponse);
    }

    @Override
    public Page<EnrollmentResponse> findByCourseId(Long courseId, Pageable pageable) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IdNotFoundException("COURSE", courseId));
        Page<Enrollment> enrollmentPage = enrollmentRepository.findByCourseId(course, pageable);
        return enrollmentPage.map(enrollmentMapper::toEnrollmentResponse);
    }
}
