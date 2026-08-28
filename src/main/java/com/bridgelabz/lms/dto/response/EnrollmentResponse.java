package com.bridgelabz.lms.dto.response;

import com.bridgelabz.lms.enums.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO returned after enrollment operations.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {

    private Long id;

    private Long studentId;

    private Long courseId;

    private LocalDateTime enrolledAt;

    private EnrollmentStatus status;
}