package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * Handles database operations for Enrollment.
 */
public interface EnrollmentRepository
        extends JpaRepository<Enrollment, Long> {

    /*
     * Checks whether a student is already
     * enrolled in a particular course.
     */
    boolean existsByStudentIdAndCourseId(
            Long studentId,
            Long courseId
    );

    /*
     * Finds a specific enrollment.
     */
    Optional<Enrollment> findByStudentIdAndCourseId(
            Long studentId,
            Long courseId
    );
}