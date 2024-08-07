package com.pabaro.ims.exception;

import com.pabaro.ims.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(SupplierNotFoundException.class)
    ResponseEntity<ErrorResponse> handleSupplierNotFoundException(SupplierNotFoundException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .status("FAILED")
                .build();
        return ResponseEntity.ok().body(errorResponse);
    }

    @ExceptionHandler(InvalidParameterException.class)
    ResponseEntity<ErrorResponse> handleInvalidParameterException(InvalidParameterException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .status("FAILED")
                .build();
        return ResponseEntity.ok().body(errorResponse);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .status("FAILED")
                .build();
        return ResponseEntity.ok().body(errorResponse);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(ex.getMessage())
                .status("FAILED")
                .build();
        return ResponseEntity.ok().body(errorResponse);
    }
}
