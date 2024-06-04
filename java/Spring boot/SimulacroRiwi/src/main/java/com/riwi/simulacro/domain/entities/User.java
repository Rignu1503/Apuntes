package com.riwi.simulacro.domain.entities;

import com.riwi.simulacro.util.enums.Role;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "user_name", length = 50)
    private String userName;

    private String password;

    @Column(length = 100)
    private String email;

    @Column(name = "full_name",length = 100)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(
            mappedBy = "userId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(
            mappedBy = "userId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<Submission> submissions = new ArrayList<>();

    @OneToMany(
            mappedBy = "instructorId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<Course> courses = new ArrayList<>();

    @OneToMany(
            mappedBy = "receiverId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<Message> messagesByReceiver = new ArrayList<>();

    @OneToMany(
            mappedBy = "senderId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<Message> messagesBySender = new ArrayList<>();
}
