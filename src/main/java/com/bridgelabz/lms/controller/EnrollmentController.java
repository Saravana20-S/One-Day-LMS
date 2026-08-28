package com.bridgelabz.lms.controller;

import com.bridgelabz.lms.dto.request.EnrollmentRequest;
import com.bridgelabz.lms.dto.response.EnrollmentResponse;
import com.bridgelabz.lms.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*

 * Handles course enrollment APIs.
 */
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    /*

     * Enrolls a student in a course.
     */
    @PostMapping("/{courseId}/enroll")
    public ResponseEntity<EnrollmentResponse> enrollStudent(
            @PathVariable Long courseId,
            @Valid @RequestBody EnrollmentRequest request) {

        EnrollmentResponse response =
                enrollmentService.enrollStudent(
                        courseId,
                        request
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }
}
