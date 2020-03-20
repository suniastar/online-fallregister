package de.coronavirus.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public abstract class RestException extends RuntimeException {

    private String error;
    private Map<String, Map<String, Object>> errors;

    public RestException(String error, String message) {
        super(message);
        this.error = error;
    }

    public RestException(String error, String message, Map<String, Map<String, Object>> errors) {
        super(message);
        this.error = error;
        this.errors = errors;
    }

    public abstract HttpStatus getStatus();

    public String getError() {
        return error;
    }

    public Map<String, Map<String, Object>> getErrors() {
        return errors;
    }
}
