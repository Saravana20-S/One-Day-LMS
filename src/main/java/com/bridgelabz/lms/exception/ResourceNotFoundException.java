package com.bridgelabz.lms.exception;

/*

 * Thrown when a requested resource
 * cannot be found in the database.
 */
public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
