package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.request.CourseRequest;
import com.bridgelabz.lms.dto.response.CourseResponse;

import java.util.List;

/**
 * Defines business operations related to courses.
 */
public interface CourseService {

    /**
     * Create a new course.
     */
    CourseResponse createCourse(
            CourseRequest request,
            Long instructorId
    );

    /**
     * Get all courses.
     */
    List<CourseResponse> getAllCourses();

    /**
     * Update an existing course.
     */
    CourseResponse updateCourse(
            Long courseId,
            CourseRequest request,
            Long instructorId
    );
}