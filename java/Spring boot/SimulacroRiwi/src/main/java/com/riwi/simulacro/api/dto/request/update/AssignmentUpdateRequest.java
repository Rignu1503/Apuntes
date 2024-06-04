package com.riwi.simulacro.api.dto.request.update;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentUpdateRequest {
    @NotBlank(message = "Assignment title must not be null")
    @Size(
            max = 100,
            message = "Assignment title cannot be longer than 100 characters."
    )
    private String assignmentTitle;

    @NotBlank(message = "Description must not be null")
    private String description;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "It is not possible to enter a date later than the current date.")
    private Date dueDate;
}
