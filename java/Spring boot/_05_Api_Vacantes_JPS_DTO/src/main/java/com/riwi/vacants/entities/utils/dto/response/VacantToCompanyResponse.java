package com.riwi.vacants.entities.utils.dto.response;

import com.riwi.vacants.entities.utils.enums.StatusVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantToCompanyResponse {
  private Long id;
  private String title;
  private String description;
  private StatusVacant status;
}
