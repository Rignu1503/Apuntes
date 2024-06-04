package com.riwi.simulacro.api.dto.request.create;

import com.riwi.simulacro.api.dto.request.update.CourseUpdateRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest extends CourseUpdateRequest {
    @NotNull(message = "Instructor id is required")
    @Min(value = 1, message = "Instructor id must be greater than 0")
    private Long instructorId;
}
