package com.bridgelabz.lms.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * Event created after a student successfully
 * submits an assignment.
 *
 * This event is sent asynchronously through JMS.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentSubmittedEvent
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * Unique ID for this event.
     */
    private String eventId;

    /*
     * Submission ID.
     */
    private Long submissionId;

    /*
     * Assignment ID.
     */
    private Long assignmentId;

    /*
     * Student who submitted the assignment.
     */
    private Long studentId;

    /*
     * Type of event.
     */
    private String eventType;

    /*
     * Time when the event occurred.
     */
    private LocalDateTime occurredAt;

    /*
     * Creates a new assignment submission event.
     */
    public static AssignmentSubmittedEvent create(
            Long submissionId,
            Long assignmentId,
            Long studentId
    ) {

        return new AssignmentSubmittedEvent(
                UUID.randomUUID().toString(),
                submissionId,
                assignmentId,
                studentId,
                "ASSIGNMENT_SUBMITTED",
                LocalDateTime.now()
        );
    }
}