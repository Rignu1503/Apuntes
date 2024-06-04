package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.CourseRequest;
import com.riwi.simulacro.api.dto.request.update.CourseUpdateRequest;
import com.riwi.simulacro.api.dto.response.CourseResponse;

public interface ICourseService extends
        CreateReadDeleteService<CourseRequest, CourseResponse, Long>,
        UpdateService<CourseUpdateRequest, CourseResponse, Long>
{
}
