package com.sofkau.saintclaireHospital.UI;

import com.sofkau.saintclaireHospital.dto.PatientDTO;

public interface IPatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    boolean deletePatient(PatientDTO patientDTO);
}
