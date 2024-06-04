package com.riwi.simulacro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    private Long id;
    private String lessonTitle;
    private String content;
    private CourseResponse courseId;
}
