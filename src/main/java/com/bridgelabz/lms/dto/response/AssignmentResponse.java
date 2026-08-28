package com.bridgelabz.lms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO returned when assignment details are requested.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentResponse {

    private Long id;

    private Long courseId;

    private String title;

    private String description;

    private LocalDateTime dueDate;
}