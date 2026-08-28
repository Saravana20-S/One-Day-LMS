package com.bridgelabz.lms.service.impl;

import com.bridgelabz.lms.dto.request.EnrollmentRequest;
import com.bridgelabz.lms.dto.response.EnrollmentResponse;
import com.bridgelabz.lms.entity.Course;
import com.bridgelabz.lms.entity.Enrollment;
import com.bridgelabz.lms.entity.User;
import com.bridgelabz.lms.enums.EnrollmentStatus;
import com.bridgelabz.lms.exception.ResourceNotFoundException;
import com.bridgelabz.lms.mapper.EnrollmentMapper;
import com.bridgelabz.lms.repository.CourseRepository;
import com.bridgelabz.lms.repository.EnrollmentRepository;
import com.bridgelabz.lms.repository.UserRepository;
import com.bridgelabz.lms.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Implementation of EnrollmentService.
 */
@Service
public class EnrollmentServiceImpl
        implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentServiceImpl(
            EnrollmentRepository enrollmentRepository,
            CourseRepository courseRepository,
            UserRepository userRepository,
            EnrollmentMapper enrollmentMapper) {

        this.enrollmentRepository =
                enrollmentRepository;

        this.courseRepository =
                courseRepository;

        this.userRepository =
                userRepository;

        this.enrollmentMapper =
                enrollmentMapper;
    }

    @Override
    public EnrollmentResponse enrollStudent(
            Long courseId,
            EnrollmentRequest request) {

        // Find course.
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                     new ResourceNotFoundException("Course not found"));

        // Find student.
        User student = userRepository
                .findById(request.getStudentId())
                .orElseThrow(() ->
                   new ResourceNotFoundException("Student not found"));

        // Create enrollment.
        Enrollment enrollment = new Enrollment();

        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.setEnrolledAt(LocalDateTime.now());
        enrollment.setStatus(EnrollmentStatus.ACTIVE);

        // Save enrollment.
        Enrollment savedEnrollment =
                enrollmentRepository.save(enrollment);

        return enrollmentMapper
                .toResponse(savedEnrollment);
    }
}