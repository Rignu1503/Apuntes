package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.AssignmentRequest;
import com.riwi.simulacro.api.dto.request.update.AssignmentUpdateRequest;
import com.riwi.simulacro.api.dto.response.AssignmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAssignmentService extends
        CreateReadDeleteService<AssignmentRequest, AssignmentResponse, Long>,
        UpdateService<AssignmentUpdateRequest, AssignmentResponse, Long>
{
    Page<AssignmentResponse> findByLessonId(Pageable pageable, Long lessonId);
}
