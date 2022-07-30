package com.sofkau.saintclaireHospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<Object> handleInvalidRequestException(InvalidRequest e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<Object> handleNotFoundEntityException(NotFound e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleCreationEntityException(EntityCreation e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleIllegalChangeException(IllegalChange e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.CONFLICT);
    }
}
