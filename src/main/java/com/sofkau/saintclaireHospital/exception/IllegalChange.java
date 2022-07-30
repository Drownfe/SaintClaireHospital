package com.sofkau.saintclaireHospital.exception;

public class IllegalChange extends IllegalStateException{
    public IllegalChange() {super();}

    public IllegalChange(String err) {
        super(err);
    }
}
