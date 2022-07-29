package com.sofkau.saintclaireHospital.Services;

import com.sofkau.saintclaireHospital.UI.ISpecialityService;
import com.sofkau.saintclaireHospital.dto.PatientDTO;
import com.sofkau.saintclaireHospital.dto.SpecialityDTO;
import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialityService implements ISpecialityService {
    @Autowired
    private SpecialityRepository medicalSpecialityRepository;



    private SpecialityDTO convertSpecialityToDTO(Speciality medicalSpeciality){
        SpecialityDTO medicalSpecialityDTO = new SpecialityDTO();
        medicalSpecialityDTO.setSpecialityId(medicalSpeciality.getId());
        medicalSpecialityDTO.setName(medicalSpeciality.getName());
        medicalSpecialityDTO.setPhysicianInCharge(medicalSpeciality.getPhysicianInCharge());
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient :medicalSpeciality.getPatients() ) {
            patientDTOS.add(convertPatientToDTO(patient));
        }
        medicalSpecialityDTO.setPatients(patientDTOS);
        return medicalSpecialityDTO;
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

    @Override
    public List<SpecialityDTO> getAllSpeciality() {
        return medicalSpecialityRepository.findAll()
                .stream()
                .map(this::convertSpecialityToDTO)
                .collect(Collectors.toList());    }

    @Override
    public SpecialityDTO createSpeciality(SpecialityDTO medicalSpecialityDTO) {
        Speciality medicalSpeciality = new Speciality();
        medicalSpeciality.setName(medicalSpecialityDTO.getName());
        medicalSpeciality.setPhysicianInCharge(medicalSpecialityDTO.getPhysicianInCharge());
        return convertSpecialityToDTO(medicalSpecialityRepository.save(medicalSpeciality));
    }
}
