package com.sofkau.saintclaireHospital.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class SpecialityDTO {
    private Long specialityId;
    private String name;
    private String physicianInCharge;
    private List<PatientDTO> patients = new ArrayList<>();
}
