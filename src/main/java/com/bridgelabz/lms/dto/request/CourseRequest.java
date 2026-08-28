package com.bridgelabz.lms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO used when an instructor creates or updates a course.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    /**
     * Course title cannot be empty.
     */
    @NotBlank(message = "Course title is required")
    @Size(min = 3, max = 100, message = "Course title must be between 3 and 100 characters")
    private String title;

    /**
     * Description cannot be empty.
     */
    @NotBlank(message = "Course description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;
}