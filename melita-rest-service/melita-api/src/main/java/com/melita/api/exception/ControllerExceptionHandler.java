package com.melita.api.exception;

import com.melita.api.model.ErrorResponseModel;
import com.melita.domain.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

/**
 * Exception handler specification for {@link com.melita.api.controller.OrderController} REST API.
 *
 * @author Roshan Bolonna
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<?> handleValidationException(ValidationException ex, WebRequest webRequest) {
        final ArrayList<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());

        final ErrorResponseModel errorResponse =
                new ErrorResponseModel("Validation errors found. ", ex.getMessages());

        return new ResponseEntity(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({RuntimeException.class, Exception.class,})
    public ResponseEntity<?> handleCommonException(Exception ex, WebRequest webRequest) {
        final ArrayList<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());

        final ErrorResponseModel errorResponse =
                new ErrorResponseModel("Error occurred while processing the order.", errors);

        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
