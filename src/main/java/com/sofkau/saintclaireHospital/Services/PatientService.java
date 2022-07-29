package com.sofkau.saintclaireHospital.Services;

import com.sofkau.saintclaireHospital.UI.IPatientService;
import com.sofkau.saintclaireHospital.dto.PatientDTO;
import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.repository.PatientRepository;
import com.sofkau.saintclaireHospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    public PatientDTO createPatient(PatientDTO patientDTO){
        Speciality speciality = specialityRepository
                .findById(patientDTO.getFkSpecialityId()).get();
        speciality.addPatient(convertDTOToPatient(patientDTO));
        Patient patient = convertDTOToPatient(patientDTO);
        patientRepository.save(patient);
        return convertPatientToDTO(patient);
    }

    private PatientDTO convertPatientToDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName(patient.getName());
        patientDTO.setAge(patient.getAge());
        patientDTO.setDni(patient.getDni());
        patientDTO.setDatesOfAppointments(patient.getDatesOfAppointments());
        patientDTO.setFkSpecialityId(patient.getFkSpecialityId());
        return patientDTO;
    }

    private Patient convertDTOToPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAge(patientDTO.getAge());
        patient.setDni(patientDTO.getDni());
        patient.setDatesOfAppointments(patientDTO.getDatesOfAppointments());
        patient.setFkSpecialityId(patientDTO.getFkSpecialityId());
        return patient;
    }
}
