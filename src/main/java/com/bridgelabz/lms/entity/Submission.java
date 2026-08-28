package com.bridgelabz.lms.entity;

import com.bridgelabz.lms.enums.SubmissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/*
 * Represents work submitted by a student
 * for an assignment.
 */
@Entity
@Table(
        name = "submissions",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "assignment_id",
                                "student_id"
                        }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Submission {

    /*
     * Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Assignment being submitted.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "assignment_id",
            nullable = false
    )
    private Assignment assignment;

    /*
     * Student who submitted the assignment.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "student_id",
            nullable = false
    )
    private User student;

    /*
     * Text content submitted by the student.
     */
    @Column(length = 5000)
    private String content;

    /*
     * Optional URL for submitted files.
     *
     * We are storing only the URL.
     * Actual file storage is outside
     * the scope of this project.
     */
    private String fileUrl;

    /*
     * Submission date and time.
     */
    @Column(nullable = false)
    private LocalDateTime submittedAt;

    /*
     * Current submission status.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubmissionStatus status;

    /*
     * Automatically sets default values
     * before inserting into the database.
     */
    @PrePersist
    public void prePersist() {

        if (submittedAt == null) {
            submittedAt = LocalDateTime.now();
        }

        if (status == null) {
            status = SubmissionStatus.SUBMITTED;
        }
    }
}