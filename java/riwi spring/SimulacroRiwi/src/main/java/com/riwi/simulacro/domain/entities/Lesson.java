package com.riwi.simulacro.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Integer id;

    @Column(name = "lesson_title",length = 100)
    private String lessonTitle;

    @Column(name = "lesson_content",columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "course_id")
    private Course courseId;

    @OneToMany(
            mappedBy = "lessonId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<Assignment> assignments = new ArrayList<>();
}
