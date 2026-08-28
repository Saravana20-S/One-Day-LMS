package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.request.EnrollmentRequest;
import com.bridgelabz.lms.dto.response.EnrollmentResponse;

/**
 * Defines enrollment-related business operations.
 */
public interface EnrollmentService {

    /**
     * Enroll a student in a course.
     */
    EnrollmentResponse enrollStudent(
            Long courseId,
            EnrollmentRequest request
    );
}