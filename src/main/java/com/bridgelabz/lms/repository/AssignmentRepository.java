package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Handles database operations for Assignment.
 */
public interface AssignmentRepository
        extends JpaRepository<Assignment, Long> {

    /*
     * Returns all assignments
     * belonging to a course.
     */
    List<Assignment> findByCourseId(Long courseId);
}