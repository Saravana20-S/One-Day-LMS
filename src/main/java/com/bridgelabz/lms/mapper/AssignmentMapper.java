package com.bridgelabz.lms.mapper;

import com.bridgelabz.lms.dto.request.AssignmentRequest;
import com.bridgelabz.lms.dto.response.AssignmentResponse;
import com.bridgelabz.lms.entity.Assignment;
import org.springframework.stereotype.Component;

/**
 * Converts Assignment DTOs and entities.
 */
@Component
public class AssignmentMapper {

    /**
     * Convert request DTO to Assignment entity.
     */
    public Assignment toEntity(AssignmentRequest request) {

        Assignment assignment = new Assignment();

        assignment.setTitle(request.getTitle());
        assignment.setDescription(request.getDescription());
        assignment.setDueDate(request.getDueDate());

        return assignment;
    }

    /**
     * Convert Assignment entity to response DTO.
     */
    public AssignmentResponse toResponse(Assignment assignment) {

        return new AssignmentResponse(
                assignment.getId(),
                assignment.getCourse().getId(),
                assignment.getTitle(),
                assignment.getDescription(),
                assignment.getDueDate()
        );
    }
}