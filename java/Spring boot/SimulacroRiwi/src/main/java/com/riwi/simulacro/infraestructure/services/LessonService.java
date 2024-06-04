package com.riwi.simulacro.infraestructure.services;

import com.riwi.simulacro.api.dto.request.create.LessonRequest;
import com.riwi.simulacro.api.dto.request.update.LessonUpdateRequest;
import com.riwi.simulacro.api.dto.response.LessonResponse;
import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.Lesson;
import com.riwi.simulacro.domain.repositories.CourseRepository;
import com.riwi.simulacro.domain.repositories.LessonRepository;
import com.riwi.simulacro.infraestructure.abstract_services.ILessonService;
import com.riwi.simulacro.infraestructure.mappers.LessonMapper;
import com.riwi.simulacro.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final LessonMapper lessonMapper;

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public LessonResponse create(LessonRequest lessonRequest) {
        Lesson lesson = lessonMapper.toLesson(lessonRequest);
        Course course = courseRepository.findById(lessonRequest.getCourseId())
                .orElseThrow(() -> new IdNotFoundException("COURSE", lessonRequest.getCourseId()));

        lesson.setCourseId(course);
        Lesson saveLesson = lessonRepository.save(lesson);
        return lessonMapper.toLessonResponse(saveLesson);
    }

    @Override
    public LessonResponse update(Long id, LessonUpdateRequest lessonRequest) {
        Lesson existingLesson = lessonRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("LESSON", id));

        lessonMapper.updateFromLessonRequest(lessonRequest, existingLesson);
        Lesson updateLesson = lessonRepository.save(existingLesson);
        return lessonMapper.toLessonResponse(updateLesson);
    }

    @Override
    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public Page<LessonResponse> getAll(Pageable pageable) {
        Page<Lesson> lessonPage = lessonRepository.findAll(pageable);
        return lessonPage.map(lessonMapper::toLessonResponse);
    }

    @Override
    public Optional<LessonResponse> getById(Long id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if (lesson.isEmpty()) throw new IdNotFoundException("LESSON", id);
        return lesson.map(lessonMapper::toLessonResponse);
    }
}
