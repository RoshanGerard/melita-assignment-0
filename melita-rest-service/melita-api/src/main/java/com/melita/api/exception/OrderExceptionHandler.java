package com.melita.api.exception;

import com.melita.api.model.ErrorResponseModel;
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
public class OrderExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class, Exception.class,})
    public ResponseEntity handleOrderException(Exception ex, WebRequest webRequest) {
        final ArrayList<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());

        final ErrorResponseModel errorResponse =
                new ErrorResponseModel("Error occurred while processing the order.", errors);

        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
