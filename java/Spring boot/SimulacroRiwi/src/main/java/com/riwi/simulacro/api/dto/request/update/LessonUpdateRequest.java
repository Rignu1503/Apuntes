package com.riwi.simulacro.api.dto.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonUpdateRequest {
    @NotBlank(message = "Lesson title must not be null")
    @Size(
            max = 100,
            message = "Lesson title cannot be longer than 100 characters."
    )
    private String lessonTitle;

    @NotBlank(message = "Content title must not be null")
    private String content;
}
