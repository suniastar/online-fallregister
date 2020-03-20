package de.coronavirus.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class NotFoundException extends RestException {

    public NotFoundException(String error, String message) {
        super(error, message);
    }

    public NotFoundException(String error, String message, Map<String, Map<String, Object>> errors) {
        super(error, message, errors);
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
