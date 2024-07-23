package com.riwi.clanes_crud.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Entity(name = "clan")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Builder.Default
    private LocalDate createdAt = LocalDate.now();
    @Builder.Default
    private LocalDate updatedAt = LocalDate.now();
    @Builder.Default
    private Boolean isActive = true;

    @ManyToOne()
    @JoinColumn(name = "cohort_id", referencedColumnName = "id")
    private Cohort cohort;

}
