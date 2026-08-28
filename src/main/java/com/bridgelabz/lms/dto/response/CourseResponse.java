package com.bridgelabz.lms.dto.response;

import com.bridgelabz.lms.enums.CourseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO returned to the client when course information is requested.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    private Long id;

    private String title;

    private String description;

    /**
     * Name or ID of the instructor.
     * This can later be changed based on authentication requirements.
     */
    private Long instructorId;

    private CourseStatus status;

    private LocalDateTime createdAt;
}