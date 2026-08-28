package com.bridgelabz.lms.service.impl;

import com.bridgelabz.lms.dto.request.SubmissionRequest;
import com.bridgelabz.lms.dto.response.SubmissionResponse;
import com.bridgelabz.lms.entity.Assignment;
import com.bridgelabz.lms.entity.Submission;
import com.bridgelabz.lms.entity.User;
import com.bridgelabz.lms.enums.SubmissionStatus;
import com.bridgelabz.lms.mapper.SubmissionMapper;
import com.bridgelabz.lms.repository.AssignmentRepository;
import com.bridgelabz.lms.repository.SubmissionRepository;
import com.bridgelabz.lms.repository.UserRepository;
import com.bridgelabz.lms.service.SubmissionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementation of SubmissionService.
 */
@Service
public class SubmissionServiceImpl
        implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final SubmissionMapper submissionMapper;

    public SubmissionServiceImpl(
            SubmissionRepository submissionRepository,
            AssignmentRepository assignmentRepository,
            UserRepository userRepository,
            SubmissionMapper submissionMapper) {

        this.submissionRepository =
                submissionRepository;

        this.assignmentRepository =
                assignmentRepository;

        this.userRepository =
                userRepository;

        this.submissionMapper =
                submissionMapper;
    }

    @Override
    public SubmissionResponse submitAssignment(
            Long assignmentId,
            SubmissionRequest request) {

        // Find assignment.
        Assignment assignment =
                assignmentRepository
                        .findById(assignmentId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Assignment not found"));

        // Find student.
        User student = userRepository
                .findById(request.getStudentId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found"));

        // Convert request DTO to entity.
        Submission submission =
                submissionMapper.toEntity(request);

        // Connect submission with assignment and student.
        submission.setAssignment(assignment);
        submission.setStudent(student);

        // Set submission details.
        submission.setSubmittedAt(
                LocalDateTime.now());

        submission.setStatus(
                SubmissionStatus.SUBMITTED);

        // Save submission.
        Submission savedSubmission =
                submissionRepository.save(submission);

        return submissionMapper
                .toResponse(savedSubmission);
    }

    @Override
    public List<SubmissionResponse>
    getSubmissionsByAssignment(
            Long assignmentId,
            Long instructorId) {

        // Find assignment.
        Assignment assignment =
                assignmentRepository
                        .findById(assignmentId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Assignment not found"));

        // Verify that the instructor owns the course.
        if (!assignment.getCourse()
                .getInstructor()
                .getId()
                .equals(instructorId)) {

            throw new RuntimeException(
                    "You are not authorized to view these submissions"
            );
        }

        // Get all submissions for the assignment.
        return submissionRepository
            .findByAssignmentId(assignmentId)
                .stream()
                .map(submissionMapper::toResponse)
                .toList();
    }
}