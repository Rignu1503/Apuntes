package com.riwi.simulacro.api.dto.request.update;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionUpdateRequest {
    @NotNull(message = "Grade cannot be null")
    @Digits(integer = 3, fraction = 2, message = "Grade must have up to 3 integer digits and up to 2 decimal places")
    @DecimalMin(value = "0.00", message = "Grade must be at least 0.00")
    @DecimalMax(value = "999.99", message = "Grade must be less than or equal to 999.99")
    private BigDecimal grade;

    @NotBlank(message = "Content title must not be null")
    private String content;
}
