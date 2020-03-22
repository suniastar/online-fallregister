package de.coronavirus.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class NotAuthorizedException extends RestException {
    public NotAuthorizedException(String error, String message) {
        super(error, message);
    }

    public NotAuthorizedException(String error, String message, Map<String, Map<String, Object>> errors) {
        super(error, message, errors);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
