package com.bridgelabz.lms.entity;

import com.bridgelabz.lms.enums.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/*
 * Represents a student's enrollment in a course.
 *
 * Enrollment acts as a connecting entity
 * between User and Course.
 */
@Entity
@Table(
        name = "enrollments",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "student_id",
                                "course_id"
                        }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {

    /*
     * Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Student who enrolled in the course.
     *
     * Many enrollments can belong to one student.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "student_id",
            nullable = false
    )
    private User student;

    /*
     * Course in which the student enrolled.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            nullable = false
    )
    private Course course;

    /*
     * Date and time of enrollment.
     */
    @Column(nullable = false)
    private LocalDateTime enrolledAt;

    /*
     * Current enrollment status.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnrollmentStatus status;

    /*
     * Automatically assigns values before saving.
     */
    @PrePersist
    public void prePersist() {

        if (enrolledAt == null) {
            enrolledAt = LocalDateTime.now();
        }

        if (status == null) {
            status = EnrollmentStatus.ACTIVE;
        }
    }
}