package com.riwi.simulacro.api.dto.request.create;

import com.riwi.simulacro.api.dto.request.update.SubmissionUpdateRequest;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest extends SubmissionUpdateRequest {
    @NotNull(message = "User id is required")
    @Min(value = 1, message = "User id must be greater than 0")
    private Long userId;

    @NotNull(message = "Assignment id is required")
    @Min(value = 1, message = "Assignment id must be greater than 0")
    private Long assignmentId;

    @NotNull(message = "Submission date is required")
    @FutureOrPresent(message = "It is not possible to enter a date later than the current date.")
    private Date submissionDate;
}
