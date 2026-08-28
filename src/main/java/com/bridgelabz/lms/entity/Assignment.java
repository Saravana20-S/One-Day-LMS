package com.bridgelabz.lms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * Represents an assignment created
 * for a particular course.
 */
@Entity
@Table(name = "assignments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assignment {

    /*
     * Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Course to which this assignment belongs.
     *
     * One course can have many assignments.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            nullable = false
    )
    private Course course;

    /*
     * Assignment title.
     */
    @Column(nullable = false)
    private String title;

    /*
     * Assignment description.
     */
    @Column(length = 3000)
    private String description;

    /*
     * Deadline for assignment submission.
     */
    @Column(nullable = false)
    private LocalDateTime dueDate;

    /*
     * One assignment can have
     * many student submissions.
     */
    @OneToMany(
            mappedBy = "assignment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Submission> submissions = new ArrayList<>();
}