package com.bridgelabz.lms.messaging.consumer;

import com.bridgelabz.lms.config.JmsConfig;
import com.bridgelabz.lms.dto.event.AssignmentSubmittedEvent;
import com.bridgelabz.lms.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/*
 * Listens for assignment submission events.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AssignmentSubmissionConsumer {

    private final NotificationService
            notificationService;

    /*
     * Receives events from the JMS queue.
     */
    @JmsListener(
            destination =
                    JmsConfig.ASSIGNMENT_SUBMITTED_QUEUE
    )
    public void consume(
            AssignmentSubmittedEvent event
    ) {

        log.info(
                "JMS event received. " +
                        "Event ID: {}",
                event.getEventId()
        );

        /*
         * Process notification.
         */
        notificationService
                .notifyAssignmentSubmitted(event);

        log.info(
                "JMS event processed successfully. " +
                        "Event ID: {}",
                event.getEventId()
        );
    }
}