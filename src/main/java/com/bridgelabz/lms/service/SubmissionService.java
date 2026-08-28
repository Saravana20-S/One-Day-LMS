package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.request.SubmissionRequest;
import com.bridgelabz.lms.dto.response.SubmissionResponse;

import java.util.List;

/**
 * Defines assignment submission operations.
 */
public interface SubmissionService {

    /**
     * Submit an assignment.
     */
    SubmissionResponse submitAssignment(
            Long assignmentId,
            SubmissionRequest request
    );

    /**
     * Get submissions for an assignment.
     */
    List<SubmissionResponse> getSubmissionsByAssignment(
            Long assignmentId,
            Long instructorId
    );
}