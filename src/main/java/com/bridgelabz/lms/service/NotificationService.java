package com.bridgelabz.lms.service;

/**
 * Handles notifications related to LMS activities.
 */
public interface NotificationService {

    /**
     * Send notification when an assignment is submitted.
     */
    void notifyAssignmentSubmission(
            Long submissionId
    );
}