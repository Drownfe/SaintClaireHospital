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
import java.util.List;

@Service
public class PatientService{
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

}
