package com.sofkau.saintclaireHospital.exception;

public class NotFound extends IllegalStateException {
    public NotFound() {
        super();
    }

    public NotFound(String err) {
        super(err);
    }
}
