package com.bridgelabz.lms.controller;

import com.bridgelabz.lms.dto.request.CourseRequest;
import com.bridgelabz.lms.dto.response.CourseResponse;
import com.bridgelabz.lms.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

 * Handles REST APIs related to courses.
 */
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    /*

     * Creates a new course.
     *
     * Temporary instructorId is passed as a request parameter.
     * Later, Spring Security will provide the authenticated user.
     */
    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(
            @Valid @RequestBody CourseRequest request,
            @RequestParam Long instructorId) {

        CourseResponse response =
                courseService.createCourse(request, instructorId);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    /*

     * Returns all courses.
     */
    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses() {

        return ResponseEntity.ok(
                courseService.getAllCourses()
        );
    }

    /*

     * Updates an existing course.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequest request,
            @RequestParam Long instructorId) {

        CourseResponse response =
                courseService.updateCourse(
                        id,
                        request,
                        instructorId
                );

        return ResponseEntity.ok(response);
    }
}
