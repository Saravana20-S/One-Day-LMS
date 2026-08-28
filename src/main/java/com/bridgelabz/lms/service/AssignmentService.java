package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.request.AssignmentRequest;
import com.bridgelabz.lms.dto.response.AssignmentResponse;

import java.util.List;

/**
 * Defines assignment-related business operations.
 */
public interface AssignmentService {

    /**
     * Create an assignment for a course.
     */
    AssignmentResponse createAssignment(
            Long courseId,
            AssignmentRequest request,
            Long instructorId
    );

    /**
     * Get all assignments for a course.
     */
    List<AssignmentResponse> getAssignmentsByCourse(
            Long courseId
    );
}