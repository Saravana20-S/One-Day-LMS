package com.bridgelabz.lms.service.impl;

import com.bridgelabz.lms.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Basic notification service.
 *
 * Later, the JMS Consumer will call this service
 * when an assignment submission event is received.
 */
@Service
public class NotificationServiceImpl
        implements NotificationService {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    NotificationServiceImpl.class);

    @Override
    public void notifyAssignmentSubmission(
            Long submissionId) {

        // Currently log the notification.
        // JMS integration will be added in Phase 7.
        logger.info(
                "Notification: Assignment submission received. Submission ID: {}",
                submissionId
        );
    }
}