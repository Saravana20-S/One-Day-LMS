package com.bridgelabz.lms.messaging.producer;

import com.bridgelabz.lms.config.JmsConfig;
import com.bridgelabz.lms.dto.event.AssignmentSubmittedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/*
 * Sends assignment submission events
 * to the JMS queue.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AssignmentSubmissionProducer {

    private final JmsTemplate jmsTemplate;

    /*
     * Sends the assignment submitted event.
     */
    public void send(
            AssignmentSubmittedEvent event
    ) {

        jmsTemplate.convertAndSend(
                JmsConfig.ASSIGNMENT_SUBMITTED_QUEUE,
                event
        );

        log.info(
                "JMS event published successfully. " +
                        "Event ID: {}, Submission ID: {}",
                event.getEventId(),
                event.getSubmissionId()
        );
    }
}