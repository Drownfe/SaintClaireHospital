package com.sofkau.saintclaireHospital.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class SpecialityDTO {
    public final Long id;
    public final String name;
    public final String physicianInCharge;
    public final Set<PatientDTO> patients;

    public SpecialityDTO(Long id, String name, String physicianInCharge, Set<PatientDTO> patients) {
        this.id = id;
        this.name = name;
        this.physicianInCharge = physicianInCharge;
        this.patients = patients;
    }
}
