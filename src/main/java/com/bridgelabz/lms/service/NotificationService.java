package com.bridgelabz.lms.service;

import com.bridgelabz.lms.dto.event.AssignmentSubmittedEvent;

/*
 * Handles LMS notifications.
 */
public interface NotificationService {

    /*
     * Processes notification for
     * assignment submission.
     */
    void notifyAssignmentSubmitted(
            AssignmentSubmittedEvent event
    );
}