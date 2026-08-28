package com.bridgelabz.lms.controller;

import com.bridgelabz.lms.dto.response.UserResponse;
import com.bridgelabz.lms.entity.User;
import com.bridgelabz.lms.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

 * Handles admin-related REST APIs.
 *
 * Security and ADMIN role authorization
 * will be added later.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*

     * Returns all registered users.
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        List<UserResponse> users = userRepository
                .findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();

        return ResponseEntity.ok(users);
    }

    /*

     * Converts User entity into UserResponse DTO.
     */
    private UserResponse convertToResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getProvider(),
                user.getRole()
        );
    }
}
