package com.melita.domain.exception;

import java.util.ArrayList;

/**
 * Data validation error exception specification.
 *
 * @author Roshan Bolonna
 */
public class ValidationException extends RuntimeException {

    private ArrayList<String> messages;

    public ValidationException() {}

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(ArrayList<String> messages) {
        super(String.join(", ", messages));
        this.messages = messages;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
}
