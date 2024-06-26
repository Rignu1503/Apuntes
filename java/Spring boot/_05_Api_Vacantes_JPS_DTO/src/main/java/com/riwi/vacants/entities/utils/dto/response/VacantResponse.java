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
public class VacantResponse {
  private Long id;
  private String title;
  private String description;
  private StatusVacant status;
  private CompanyToVancantResponse company;
}
