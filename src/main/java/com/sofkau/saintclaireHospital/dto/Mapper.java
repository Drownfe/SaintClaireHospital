package com.sofkau.saintclaireHospital.dto;

import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;

import java.util.stream.Collectors;

public final class Mapper {

    private Mapper(){
    }

    public static SpecialityDTO createSpecialityDTO(Speciality speciality) {
        return new SpecialityDTO(
                speciality.getId(),
                speciality.getName(),
                speciality.getPhysicianInCharge(),
                speciality.getPatients()
                        .stream()
                        .map(Mapper::createPatientDTO)
                        .collect(Collectors.toSet())
        );
    }

    public static Speciality createSpecialityEntity(SpecialityDTO speciality) {
        return new Speciality(
                speciality.id,
                speciality.name,
                speciality.physicianInCharge
        );
    }

    public static PatientDTO createPatientDTO(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getDni(),
                patient.getName(),
                patient.getAge(),
                patient.getDatesAppointments(),
                patient.getNumberOfAppointments()
        );
    }

    public static Patient createPatientEntity(PatientDTO patientDTO) {
        boolean hasId = patientDTO.id != null;
        if(!hasId) {
            return new Patient(patientDTO.dni, patientDTO.name, patientDTO.age);
        }
        return new Patient(
                patientDTO.id,
                patientDTO.dni,
                patientDTO.name,
                patientDTO.age,
                String.join(";", patientDTO.datesAppointments),
                patientDTO.numberOfAppointments
        );
    }
}
