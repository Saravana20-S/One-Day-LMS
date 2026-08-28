package com.bridgelabz.lms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO used by a student to submit an assignment.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionRequest {

    /**
     * ID of the student submitting the assignment.
     */
    private Long studentId;

    /**
     * Submission content.
     */
    @NotBlank(message = "Submission content is required")
    @Size(min = 1, max = 5000,
            message = "Submission content must not exceed 5000 characters")
    private String content;

    /**
     * Optional URL of the submitted file.
     */
    private String fileUrl;
}