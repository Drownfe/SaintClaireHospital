package com.sofkau.saintclaireHospital.Services;

import com.sofkau.saintclaireHospital.dto.Mapper;
import com.sofkau.saintclaireHospital.dto.SpecialityDTO;
import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.exception.EntityCreation;
import com.sofkau.saintclaireHospital.exception.IllegalChange;
import com.sofkau.saintclaireHospital.exception.NotFound;
import com.sofkau.saintclaireHospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class SpecialityService {
    private SpecialityRepository specialityRepository;
    @Autowired
    private PatientService patientService;

    public List<Speciality> getSpecialities() {
        return specialityRepository.findAll();
    }

    public Speciality getSpeciality(Long id) {
        Optional<Speciality> byId = specialityRepository.findById(id);
        if (byId.isEmpty()) throw new NotFound("Speciality not into records");
        return byId.get();
    }

    @Transactional
    public Speciality addPatient(Long specialityId, Long patientId, String date) {
        Optional<Speciality> byId = specialityRepository.findById(specialityId);
        if(byId.isEmpty()) {
            throw new NotFound("This specialty doesn't exist");
        }
        Speciality speciality = byId.get();
        Patient patient = patientService.addPatientDate(patientId, date);
        patient.setSpeciality(speciality);
        speciality.getPatients().add(patient);
        return speciality;
    }
    @Transactional
    public Speciality updateSpeciality(Long specialtyId, String name, String physicianInCharge) {
        Speciality specialty = getSpeciality(specialtyId);
        if(name != null) {
            checkSpecialtyName(name);
            specialty.setName(name);
        }

        if(physicianInCharge != null) {
            checkSpecialtyPhysician(physicianInCharge);
            specialty.setPhysicianInCharge(physicianInCharge);
        }
        return specialty;
    }
    public Speciality createSpeciality(SpecialityDTO specialty) {
        checkSpecialtyName(specialty.name);
        checkSpecialtyPhysician(specialty.physicianInCharge);
        return specialityRepository.save(
                Mapper.createSpecialityEntity(specialty)
        );
    }
    private void checkSpecialtyName(String name) {
        int nameLen = name.length();
        if(nameLen < 5 || nameLen > 100) throw new EntityCreation("Specialty name must be between 5 & 100 characters");
    }
    private void checkSpecialtyPhysician(String physicianInCharge) {
        int nameLen = physicianInCharge.length();
        if(nameLen < 10 || nameLen > 45) throw new EntityCreation("Physician in charge name must be between 10 & 45 characters");
    }
    public Speciality deleteSpeciality(Long specialtyId) {
        Speciality speciality = getSpeciality(specialtyId);
        int quantityPatients = speciality.getPatients().size();
        if(quantityPatients > 0) throw new IllegalChange("This specialty still have patients");
        specialityRepository.delete(speciality);
        return speciality;
    }

}
