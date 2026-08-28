package com.bridgelabz.lms.config;

import org.springframework.context.annotation.Configuration;

/*
 * Central JMS configuration constants.
 */
@Configuration
public class JmsConfig {

    /*
     * Queue used when an assignment
     * is successfully submitted.
     */
    public static final String
            ASSIGNMENT_SUBMITTED_QUEUE =
            "assignment.submitted";
}