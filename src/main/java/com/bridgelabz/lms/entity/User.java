package com.bridgelabz.lms.entity;

import com.bridgelabz.lms.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/*
 * Represents a user in the LMS.
 *
 * Users can have one of these roles:
 * ADMIN
 * INSTRUCTOR
 * STUDENT
 *
 * In the future, OAuth2/OIDC login information
 * can be mapped to this user.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    /*
     * Primary key.
     *
     * GenerationType.IDENTITY lets PostgreSQL
     * generate the ID automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Full name of the user.
     */
    @Column(nullable = false)
    private String name;

    /*
     * Email should be unique because it identifies
     * the logged-in user.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /*
     * OAuth/OIDC provider.
     *
     * Example:
     * GOOGLE
     * GITHUB
     * KEYCLOAK
     */
    private String provider;

    /*
     * Stores the user's role as a String.
     *
     * Example:
     * ADMIN
     * INSTRUCTOR
     * STUDENT
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    /*
     * An instructor can create many courses.
     *
     * mappedBy = "instructor"
     * means the Course entity owns the relationship.
     */
    @OneToMany(mappedBy = "instructor")
    @Builder.Default
    private List<Course> courses = new ArrayList<>();

    /*
     * A student can enroll in many courses.
     */
    @OneToMany(mappedBy = "student")
    @Builder.Default
    private List<Enrollment> enrollments = new ArrayList<>();

    /*
     * A student can submit many assignments.
     */
    @OneToMany(mappedBy = "student")
    @Builder.Default
    private List<Submission> submissions = new ArrayList<>();
}