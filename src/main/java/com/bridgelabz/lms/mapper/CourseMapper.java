package com.bridgelabz.lms.mapper;

import com.bridgelabz.lms.dto.request.CourseRequest;
import com.bridgelabz.lms.dto.response.CourseResponse;
import com.bridgelabz.lms.entity.Course;
import org.springframework.stereotype.Component;

/**
 * Converts Course Entity to CourseResponse DTO
 * and CourseRequest DTO to Course Entity.
 */
@Component
public class CourseMapper {

    /**
     * Convert request DTO to entity.
     */
    public Course toEntity(CourseRequest request) {

        Course course = new Course();

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());

        return course;
    }

    /**
     * Convert entity to response DTO.
     */
    public CourseResponse toResponse(Course course) {

        return new CourseResponse(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getInstructor().getId(),
                course.getStatus(),
                course.getCreatedAt()
        );
    }
}