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
public class CourseUpdateRequest {
    @NotBlank(message = "Course name must not be null")
    @Size(
            max = 100,
            message = "Course name cannot be longer than 100 characters."
    )
    private String courseName;

    @NotBlank(message = "Description title must not be null")
    private String description;
}
