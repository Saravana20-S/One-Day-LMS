package com.bridgelabz.lms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*

 * Standard response returned when an error occurs.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    /*

     * Date and time when the error occurred.
     */
    private LocalDateTime timestamp;

    /*

     * HTTP status code.
     */
    private int status;

    /*

     * Error type.
     */
    private String error;

    /*

     * Detailed error message.
     */
    private String message;

    /*

     * API path where the error occurred.
     */
    private String path;
}
