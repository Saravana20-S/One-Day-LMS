package com.bridgelabz.lms.entity;

import com.bridgelabz.lms.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * Represents a course created by an instructor.
 */
@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    /*
     * Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Course title.
     *
     * Example:
     * Java Full Stack Development
     */
    @Column(nullable = false)
    private String title;

    /*
     * Detailed information about the course.
     */
    @Column(length = 2000)
    private String description;

    /*
     * Many courses can belong to one instructor.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "instructor_id",
            nullable = false
    )
    private User instructor;

    /*
     * Current status of the course.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseStatus status;

    /*
     * Stores when the course was created.
     */
    @Column(nullable = false)
    private LocalDateTime createdAt;

    /*
     * One course can have many student enrollments.
     */
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Enrollment> enrollments = new ArrayList<>();

    /*
     * One course can contain many assignments.
     */
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Assignment> assignments = new ArrayList<>();

    /*
     * Automatically sets the creation time
     * before the entity is inserted.
     */
    @PrePersist
    public void prePersist() {

        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }

        if (status == null) {
            status = CourseStatus.DRAFT;
        }
    }
}