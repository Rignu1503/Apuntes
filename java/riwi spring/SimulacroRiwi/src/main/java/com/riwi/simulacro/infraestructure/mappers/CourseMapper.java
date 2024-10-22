package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.create.CourseRequest;
import com.riwi.simulacro.api.dto.request.update.CourseUpdateRequest;
import com.riwi.simulacro.api.dto.response.CourseResponse;
import com.riwi.simulacro.domain.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CourseMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "instructorId.id", source = "instructorId")
    })
    Course toCourse(CourseRequest courseRequest);

    CourseResponse toCourseResponse(Course course);
    void updateFromCourseRequest(CourseUpdateRequest courseRequest, @MappingTarget Course course);
}
