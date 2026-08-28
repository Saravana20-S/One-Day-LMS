package com.bridgelabz.lms.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO used when a student enrolls in a course.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequest {

    /**
     * ID of the student who wants to enroll.
     */
    @NotNull(message = "Student ID is required")
    private Long studentId;
}