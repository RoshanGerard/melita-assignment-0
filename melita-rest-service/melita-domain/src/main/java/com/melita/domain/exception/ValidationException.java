package com.melita.domain.exception;

import java.util.ArrayList;

/**
 * Data validation error exception specificaiton.
 *
 * @author Roshan Bolonna
 */
public class ValidationException extends RuntimeException {

    public ValidationException() {}

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(ArrayList<String> messages) {
        super(String.join("\n", messages));
    }
}
