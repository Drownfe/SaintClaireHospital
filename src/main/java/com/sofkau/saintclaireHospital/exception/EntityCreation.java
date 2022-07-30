package com.sofkau.saintclaireHospital.exception;

public class EntityCreation extends IllegalStateException {
    public EntityCreation() {super();}

    public EntityCreation(String err) {
        super(err);
    }
}
