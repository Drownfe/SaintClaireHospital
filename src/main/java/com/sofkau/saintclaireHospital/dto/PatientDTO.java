package com.sofkau.saintclaireHospital.dto;

import lombok.Data;

@Data
public class PatientDTO {
    private String name;
    private int age;
    private Long dni;
    private String datesOfAppointments;
}