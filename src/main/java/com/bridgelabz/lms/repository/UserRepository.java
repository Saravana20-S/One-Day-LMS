package com.bridgelabz.lms.repository;

import com.bridgelabz.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * Handles database operations for User.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /*
     * Finds a user using email.
     */
    Optional<User> findByEmail(String email);
}