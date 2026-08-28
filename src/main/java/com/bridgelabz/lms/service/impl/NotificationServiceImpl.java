package com.bridgelabz.lms.service.impl;

import com.bridgelabz.lms.dto.event.AssignmentSubmittedEvent;
import com.bridgelabz.lms.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 * Handles notification processing.
 *
 * Currently logs the notification.
 * Later this can be extended to support
 * email, SMS or push notifications.
 */
@Slf4j
@Service
public class NotificationServiceImpl
        implements NotificationService {

    @Override
    public void notifyAssignmentSubmitted(
            AssignmentSubmittedEvent event
    ) {

        log.info(
                "NOTIFICATION: Assignment submitted. " +
                        "Student ID: {}, Assignment ID: {}, " +
                        "Submission ID: {}",
                event.getStudentId(),
                event.getAssignmentId(),
                event.getSubmissionId()
        );
    }
}