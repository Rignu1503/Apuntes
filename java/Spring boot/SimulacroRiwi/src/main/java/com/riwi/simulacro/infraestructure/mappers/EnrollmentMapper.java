package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.create.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.EnrollmentResponse;
import com.riwi.simulacro.domain.entities.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CourseMapper.class})
public interface EnrollmentMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "courseId.id", source = "courseId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    Enrollment toEnrollment(EnrollmentRequest enrollmentRequest);

    EnrollmentResponse toEnrollmentResponse(Enrollment enrollment);
}
