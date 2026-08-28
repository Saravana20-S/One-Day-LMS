package com.bridgelabz.lms.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO used by an instructor to create an assignment.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentRequest {

    /**
     * Assignment title.
     */
    @NotBlank(message = "Assignment title is required")
    @Size(min = 3, max = 150,
            message = "Assignment title must be between 3 and 150 characters")
    private String title;

    /**
     * Assignment description.
     */
    @NotBlank(message = "Assignment description is required")
    @Size(min = 10, max = 2000,
            message = "Description must be between 10 and 2000 characters")
    private String description;

    /**
     * Assignment due date must be in the future.
     */
    @NotNull(message = "Due date is required")
    @Future(message = "Due date must be in the future")
    private LocalDateTime dueDate;
}