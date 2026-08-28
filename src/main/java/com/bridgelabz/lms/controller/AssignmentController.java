package com.bridgelabz.lms.controller;

import com.bridgelabz.lms.dto.request.AssignmentRequest;
import com.bridgelabz.lms.dto.response.AssignmentResponse;
import com.bridgelabz.lms.service.AssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

 * Handles assignment-related REST APIs.
 */
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    /*

     * Creates an assignment for a course.
     */
    @PostMapping("/{courseId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(
            @PathVariable Long courseId,
            @Valid @RequestBody AssignmentRequest request,
            @RequestParam Long instructorId) {

        AssignmentResponse response =
                assignmentService.createAssignment(
                        courseId,
                        request,
                        instructorId
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    /*

     * Returns all assignments for a course.
     */
    @GetMapping("/{courseId}/assignments")
    public ResponseEntity<List<AssignmentResponse>>
    getAssignmentsByCourse(
            @PathVariable Long courseId) {

        return ResponseEntity.ok(
                assignmentService
                        .getAssignmentsByCourse(courseId)
        );
    }
}
