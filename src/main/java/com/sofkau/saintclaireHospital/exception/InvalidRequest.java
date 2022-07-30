package com.sofkau.saintclaireHospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class InvalidRequest extends IllegalStateException{
    public InvalidRequest() {
        super();
    }

    public InvalidRequest(String err) {
        super(err);
    }
}
