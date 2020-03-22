package de.coronavirus.domain.exception;

public class ValueRequiredException extends RuntimeException {

    public ValueRequiredException(String message) {
        super(message);
    }
}
