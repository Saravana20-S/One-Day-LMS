package com.bridgelabz.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Main entry point of the LMS application.
 *
 * @SpringBootApplication includes:
 *
 * 1. @Configuration
 *    - Allows Java-based configuration.
 *
 * 2. @EnableAutoConfiguration
 *    - Spring Boot automatically configures
 *      components based on dependencies.
 *
 * 3. @ComponentScan
 *    - Scans all components inside:
 *      com.bridgelabz.lms
 *
 * Therefore, all our packages such as:
 *
 * controller
 * service
 * repository
 * config
 * exception
 *
 * should remain inside com.bridgelabz.lms.
 */
@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {

		// Starts the Spring Boot application
		SpringApplication.run(LmsApplication.class, args);
	}
}