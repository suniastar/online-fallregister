package de.coronavirus.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.coronavirus.domain.exception.RestException;
import de.coronavirus.domain.exception.ValueRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class DomainExceptionHandler {

    @ExceptionHandler(ValueRequiredException.class)
    public ResponseEntity<ApiError> handleValueRequiredException(ValueRequiredException e) {
        return getApiErrorResponseEntity(HttpStatus.BAD_REQUEST, "VALUE_REQUIRED", e);
    }

    private ResponseEntity<ApiError> getApiErrorResponseEntity(HttpStatus status, String error, Throwable e) {
        ApiError apiError = new ApiError(status, error, e.getLocalizedMessage());
        return ResponseEntity.status(status).body(apiError);
    }

    @JsonPropertyOrder({"code", "status", "timestamp", "error", "message", "errors"})
    private static class ApiError {

        private LocalDateTime timestamp;
        private HttpStatus status;
        private String error;
        private String message;
        private Map<String, Map<String, Object>> errors;

        private ApiError() {
            this.timestamp = LocalDateTime.now();
        }

        public ApiError(RestException exception) {
            this();
            this.status = exception.getStatus();
            this.message = exception.getMessage();
            this.error = exception.getError();
            this.errors = exception.getErrors();
        }

        public ApiError(HttpStatus status) {
            this();
            this.status = status;
        }

        public ApiError(HttpStatus status, String error) {
            this();
            this.status = status;
            this.error = error;
        }

        public ApiError(HttpStatus status, String error, String message) {
            this();
            this.status = status;
            this.error = error;
            this.message = message;
        }

        public ApiError(HttpStatus status, String error, String message, Map<String, Map<String, Object>> errors) {
            this();
            this.status = status;
            this.error = error;
            this.message = message;
            this.errors = errors;
        }

        @JsonProperty
        public int getCode() {
            return status.value();
        }

        public HttpStatus getStatus() {
            return status;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public String getError() {
            return error;
        }

        public String getMessage() {
            return message;
        }

        public Map<String, Map<String, Object>> getErrors() {
            return errors;
        }
    }
}
