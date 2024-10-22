package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.EnrollmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEnrollmentService extends
        CreateReadDeleteService<EnrollmentRequest, EnrollmentResponse, Long>
{
    Page<EnrollmentResponse> findByUserId(Long userId, Pageable pageable);
    Page<EnrollmentResponse> findByCourseId(Long courseId, Pageable pageable);
}
