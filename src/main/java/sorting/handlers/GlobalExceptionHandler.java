package sorting.handlers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "Invalid number array.")
    public void handleInvalidInput() {
        // Respond with a HttpStatus of 412 - Precondition failed
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "Unable to store result.")
    public void handleDatabaseErrors() {
        // Respond with a HttpStatus of 417 - Expectation failed
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Request body is missing.")
    public void handleEmptyPosts() {
        // Respond with a HttpStatus of 400 - Bad request
    }
}
