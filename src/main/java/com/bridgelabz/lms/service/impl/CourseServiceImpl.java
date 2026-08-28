package com.bridgelabz.lms.service.impl;

import com.bridgelabz.lms.dto.request.CourseRequest;
import com.bridgelabz.lms.dto.response.CourseResponse;
import com.bridgelabz.lms.entity.Course;
import com.bridgelabz.lms.entity.User;
import com.bridgelabz.lms.exception.BusinessException;
import com.bridgelabz.lms.exception.ResourceNotFoundException;
import com.bridgelabz.lms.mapper.CourseMapper;
import com.bridgelabz.lms.repository.CourseRepository;
import com.bridgelabz.lms.repository.UserRepository;
import com.bridgelabz.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of CourseService.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponse createCourse(
            CourseRequest request,
            Long instructorId) {

        log.info(
                "Creating course for instructor ID: {}",
                instructorId
        );

        // Find the instructor.
        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Instructor not found"));

        // Convert DTO to entity.
        Course course = courseMapper.toEntity(request);

        // Connect course with instructor.
        course.setInstructor(instructor);

        // Save course.
        Course savedCourse = courseRepository.save(course);

        log.info(
                "Course created successfully. Course ID: {}",
                savedCourse.getId()
        );

        // Convert entity to response DTO.
        return courseMapper.toResponse(savedCourse);
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        // Get all courses and convert them into response DTOs.
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    @Override
    public CourseResponse updateCourse(
            Long courseId,
            CourseRequest request,
            Long instructorId) {

        // Find the course.
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                   new ResourceNotFoundException("Course not found"));

        // Verify that the instructor owns the course.
        if (!course.getInstructor().getId()
                .equals(instructorId)) {

            throw new BusinessException(
                    "You are not authorized to update this course"
            );
        }

        // Update fields.
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());

        // Save updated course.
        Course updatedCourse = courseRepository.save(course);

        return courseMapper.toResponse(updatedCourse);
    }
}