package com.melita.api.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Common error response model for REST Controller runtime error handling.
 *
 * @author Roshan G. Bolonna
 */
@JsonRootName("httpError")
public class ErrorResponseModel {

    private String message;
    private List<String> details;

    public ErrorResponseModel(String message, List<String> details) {
        setMessage(message);
        setDetails(details);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

}
