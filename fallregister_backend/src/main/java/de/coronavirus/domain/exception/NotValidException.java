package de.coronavirus.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class NotValidException extends RestException {

    public NotValidException(String error, String message) {
        super(error, message);
    }

    public NotValidException(String error, String message, Map<String, Map<String, Object>> errors) {
        super(error, message, errors);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
