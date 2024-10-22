package com.riwi.simulacro.api.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResponse {
    private Long id;
    private String assignmentTitle;
    private String description;
    private Date dueDate;
    private LessonResponse lessonId;
}
