package com.bridgelabz.lms.mapper;

import com.bridgelabz.lms.dto.response.EnrollmentResponse;
import com.bridgelabz.lms.entity.Enrollment;
import org.springframework.stereotype.Component;

/**
 * Converts Enrollment Entity to EnrollmentResponse DTO.
 */
@Component
public class EnrollmentMapper {

    public EnrollmentResponse toResponse(Enrollment enrollment) {

        return new EnrollmentResponse(
                enrollment.getId(),
                enrollment.getStudent().getId(),
                enrollment.getCourse().getId(),
                enrollment.getEnrolledAt(),
                enrollment.getStatus()
        );
    }
}