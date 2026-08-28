package com.bridgelabz.lms.service.impl;

import com.bridgelabz.lms.dto.request.AssignmentRequest;
import com.bridgelabz.lms.dto.response.AssignmentResponse;
import com.bridgelabz.lms.entity.Assignment;
import com.bridgelabz.lms.entity.Course;
import com.bridgelabz.lms.exception.BusinessException;
import com.bridgelabz.lms.exception.ResourceNotFoundException;
import com.bridgelabz.lms.mapper.AssignmentMapper;
import com.bridgelabz.lms.repository.AssignmentRepository;
import com.bridgelabz.lms.repository.CourseRepository;
import com.bridgelabz.lms.service.AssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of AssignmentService.
 */
@Service
public class AssignmentServiceImpl
        implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final CourseRepository courseRepository;
    private final AssignmentMapper assignmentMapper;

    public AssignmentServiceImpl(
            AssignmentRepository assignmentRepository,
            CourseRepository courseRepository,
            AssignmentMapper assignmentMapper) {

        this.assignmentRepository =
                assignmentRepository;

        this.courseRepository =
                courseRepository;

        this.assignmentMapper =
                assignmentMapper;
    }

    @Override
    public AssignmentResponse createAssignment(
            Long courseId,
            AssignmentRequest request,
            Long instructorId) {

        // Find course.
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found"));

        // Verify instructor ownership.
        if (!course.getInstructor().getId()
                .equals(instructorId)) {

            throw new BusinessException(
                    "You are not authorized to create assignments for this course"
            );
        }

        // Convert request DTO to entity.
        Assignment assignment =
                assignmentMapper.toEntity(request);

        // Connect assignment with course.
        assignment.setCourse(course);

        // Save assignment.
        Assignment savedAssignment =
                assignmentRepository.save(assignment);

        return assignmentMapper
                .toResponse(savedAssignment);
    }

    @Override
    public List<AssignmentResponse>
    getAssignmentsByCourse(Long courseId) {

        // Verify course exists.
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found"));

        // Get assignments.
        return assignmentRepository
                .findByCourseId(courseId)
                .stream()
                .map(assignmentMapper::toResponse)
                .toList();
    }
}