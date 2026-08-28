package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Handles database operations for Course.
 */
public interface CourseRepository
        extends JpaRepository<Course, Long> {
}