package com.sofkau.saintclaireHospital.Services;

import com.sofkau.saintclaireHospital.UI.IPatientService;
import com.sofkau.saintclaireHospital.dto.Mapper;
import com.sofkau.saintclaireHospital.dto.PatientDTO;
import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.exception.InvalidRequest;
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
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatient(Long id) {
        Optional<Patient> byId = patientRepository.findById(id);
        if (byId.isEmpty()) throw new InvalidRequest("Patient not into records");
        return byId.get();
    }

    public Patient addPatientDate(Long patientId, String date) {
        Patient patient = getPatient(patientId);
        patient.setNumberOfAppointments(patient.getNumberOfAppointments() + 1);
        patient.setDatesAppointments(date);
        return patient;
    }

    public Patient createPatient(PatientDTO patient) {
        checkPatient(patient);
        return patientRepository.save(
                Mapper.createPatientEntity(patient)
        );
    }

    private void checkPatient(PatientDTO patient) {
        int nameLen = patient.name.length();
        if (nameLen < 10 || nameLen > 45) throw new InvalidRequest("Patient name must be between 10 & 45 characters");

        if (patient.age <= 0) throw new InvalidRequest("Patient age can't be zero or less");
    }

    public Patient deletePatient(Long id) {
        Patient patient = getPatient(id);
        patientRepository.deleteById(id);
        return patient;
    }

    @Transactional
    public Patient deletePatientAppointments(Long id, int newSize, boolean reverse) {
        Patient patient = getPatient(id);
        if(newSize <= 0) patient.setSpeciality(null);

        if (!reverse) patient.setNumberOfAppointments(newSize);
        else patient.setNumberOfAppointments((long) newSize);

        return patient;
    }
}
