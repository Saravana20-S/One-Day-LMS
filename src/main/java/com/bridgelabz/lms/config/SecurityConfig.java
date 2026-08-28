package com.bridgelabz.lms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
 * Configures:
 * 1. Authentication
 * 2. OAuth2 / OIDC Login
 * 3. Role-based authorization
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http

                /*
                 * REST API configuration.
                 */
                .csrf(csrf -> csrf.disable())

                /*
                 * Configure endpoint authorization.
                 */
                .authorizeHttpRequests(auth -> auth

                        /*
                         * ADMIN endpoints.
                         */
                        .requestMatchers("/api/admin/**")
                        .hasRole("ADMIN")

                        /*
                         * Course creation.
                         */
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/courses"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR"
                        )

                        /*
                         * Course update.
                         */
                        .requestMatchers(
                                HttpMethod.PUT,
                                "/api/courses/**"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR"
                        )

                        /*
                         * Student enrollment.
                         */
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/courses/*/enroll"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "STUDENT"
                        )

                        /*
                         * Assignment creation.
                         */
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/courses/*/assignments"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR"
                        )

                        /*
                         * Viewing assignments.
                         */
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/courses/*/assignments"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR",
                                "STUDENT"
                        )

                        /*
                         * Student assignment submission.
                         */
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/assignments/*/submissions"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "STUDENT"
                        )

                        /*
                         * Viewing submissions.
                         */
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/assignments/*/submissions"
                        )
                        .hasAnyRole(
                                "ADMIN",
                                "INSTRUCTOR"
                        )

                        /*
                         * Course browsing.
                         */
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/courses/**"
                        )
                        .authenticated()

                        /*
                         * Everything else requires login.
                         */
                        .anyRequest()
                        .authenticated()
                )

                /*
                 * Enable OAuth2 / OIDC login.
                 */
                .oauth2Login(
                        Customizer.withDefaults()
                );

        return http.build();
    }
}