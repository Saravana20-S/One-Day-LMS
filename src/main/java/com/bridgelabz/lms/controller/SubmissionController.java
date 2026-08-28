package com.bridgelabz.lms.controller;

import com.bridgelabz.lms.dto.request.SubmissionRequest;
import com.bridgelabz.lms.dto.response.SubmissionResponse;
import com.bridgelabz.lms.service.SubmissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

 * Handles assignment submission APIs.
 */
@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    /*

     * Allows a student to submit an assignment.
     */
    @PostMapping("/{assignmentId}/submissions")
    public ResponseEntity<SubmissionResponse> submitAssignment(
            @PathVariable Long assignmentId,
            @Valid @RequestBody SubmissionRequest request) {

        SubmissionResponse response =
                submissionService.submitAssignment(
                        assignmentId,
                        request
                );

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    /*

     * Returns all submissions for an assignment.
     *
     * Temporary instructorId is passed as a request parameter.
     * Later, this will come from Spring Security.
     */
    @GetMapping("/{assignmentId}/submissions")
    public ResponseEntity<List<SubmissionResponse>>
    getSubmissionsByAssignment(
            @PathVariable Long assignmentId,
            @RequestParam Long instructorId) {

        return ResponseEntity.ok(
                submissionService.getSubmissionsByAssignment(
                        assignmentId,
                        instructorId
                )
        );
    }
}
