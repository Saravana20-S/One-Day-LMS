package com.bridgelabz.lms.dto.response;

import com.bridgelabz.lms.enums.SubmissionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO returned after assignment submission.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionResponse {

    private Long id;

    private Long assignmentId;

    private Long studentId;

    private String content;

    private String fileUrl;

    private LocalDateTime submittedAt;

    private SubmissionStatus status;
}