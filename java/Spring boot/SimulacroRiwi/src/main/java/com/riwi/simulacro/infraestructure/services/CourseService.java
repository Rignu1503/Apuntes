package com.riwi.simulacro.infraestructure.services;

import com.riwi.simulacro.api.dto.request.create.CourseRequest;
import com.riwi.simulacro.api.dto.request.update.CourseUpdateRequest;
import com.riwi.simulacro.api.dto.response.CourseResponse;
import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.User;
import com.riwi.simulacro.domain.repositories.CourseRepository;
import com.riwi.simulacro.domain.repositories.UserRepository;
import com.riwi.simulacro.infraestructure.abstract_services.ICourseService;
import com.riwi.simulacro.infraestructure.mappers.CourseMapper;
import com.riwi.simulacro.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final CourseMapper courseMapper;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public CourseResponse create(CourseRequest courseRequest) {
        Course course = courseMapper.toCourse(courseRequest);
        User instructor = userRepository.findById(courseRequest.getInstructorId())
                .orElseThrow(() -> new IdNotFoundException("USER", courseRequest.getInstructorId()));

        course.setInstructorId(instructor);
        Course saveCourse = courseRepository.save(course);
        return courseMapper.toCourseResponse(saveCourse);
    }

    @Override
    public CourseResponse update(Long id, CourseUpdateRequest courseRequest) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("COURSE", id));

        courseMapper.updateFromCourseRequest(courseRequest, existingCourse);
        Course updateCourse = courseRepository.save(existingCourse);
        return courseMapper.toCourseResponse(updateCourse);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Page<CourseResponse> getAll(Pageable pageable) {
        Page<Course> coursePage = courseRepository.findAll(pageable);
        return coursePage.map(courseMapper::toCourseResponse);
    }

    @Override
    public Optional<CourseResponse> getById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) throw new IdNotFoundException("COURSE", id);
        return course.map(courseMapper::toCourseResponse);
    }
}
