package com.riwi.simulacro.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "assignment_title",length = 100)
    private String assignmentTitle;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "lesson_id")
    private Lesson lessonId;

    @OneToMany(
            mappedBy = "assignmentId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<Submission> submissions = new ArrayList<>();
}
