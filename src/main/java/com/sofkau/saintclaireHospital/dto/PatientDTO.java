package com.sofkau.saintclaireHospital.dto;

import lombok.Data;

import java.util.List;

@Data
public class PatientDTO {
    public Long id;
    public Long dni;
    public String name;
    public Integer age;
    public List<String> datesAppointments;
    public Long numberOfAppointments;

    public PatientDTO(Long id, Long dni, String name, Integer age, List<String> datesAppointments, Long numberOfAppointments) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.datesAppointments = datesAppointments;
        this.numberOfAppointments = numberOfAppointments;
    }

}
