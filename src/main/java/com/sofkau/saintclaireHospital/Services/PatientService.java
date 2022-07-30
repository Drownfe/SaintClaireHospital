package com.sofkau.saintclaireHospital.Services;

import com.sofkau.saintclaireHospital.UI.IPatientService;
import com.sofkau.saintclaireHospital.dto.PatientDTO;
import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.repository.PatientRepository;
import com.sofkau.saintclaireHospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService{
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }
    public Patient getPatient(Long id) {
        Optional<Patient> byId = patientRepository.findById(id);
        if (byId.isEmpty()) throw new IllegalStateException("Patient not into records");
        return byId.get();
    }
    public Patient addPatientDate(Long patientId, String date) {
        Patient patient = getPatient(patientId);
        patient.setNumberOfAppointments(patient.getNumberOfAppointments() + 1);
        patient.setDatesAppointments(date);
        return patient;
    }

}
