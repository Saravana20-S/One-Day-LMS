package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Handles database operations for Submission.
 */
public interface SubmissionRepository
        extends JpaRepository<Submission, Long> {

    /*
     * Finds all submissions
     * for a particular assignment.
     */
    List<Submission> findByAssignmentId(Long assignmentId);

    /*
     * Checks whether a student has already
     * submitted an assignment.
     */
    boolean existsByAssignmentIdAndStudentId(
            Long assignmentId,
            Long studentId
    );
}