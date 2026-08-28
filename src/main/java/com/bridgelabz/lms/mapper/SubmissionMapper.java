package com.bridgelabz.lms.mapper;

import com.bridgelabz.lms.dto.request.SubmissionRequest;
import com.bridgelabz.lms.dto.response.SubmissionResponse;
import com.bridgelabz.lms.entity.Submission;
import org.springframework.stereotype.Component;

/**
 * Converts Submission DTOs and entities.
 */
@Component
public class SubmissionMapper {

    /**
     * Convert request DTO to Submission entity.
     */
    public Submission toEntity(SubmissionRequest request) {

        Submission submission = new Submission();

        submission.setContent(request.getContent());
        submission.setFileUrl(request.getFileUrl());

        return submission;
    }

    /**
     * Convert Submission entity to response DTO.
     */
    public SubmissionResponse toResponse(Submission submission) {

        return new SubmissionResponse(
                submission.getId(),
                submission.getAssignment().getId(),
                submission.getStudent().getId(),
                submission.getContent(),
                submission.getFileUrl(),
                submission.getSubmittedAt(),
                submission.getStatus()
        );
    }
}