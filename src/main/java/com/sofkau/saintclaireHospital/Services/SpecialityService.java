package com.sofkau.saintclaireHospital.Services;

import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SpecialityService{
    private SpecialityRepository specialityRepository;
    @Autowired
    private PatientService patientService;
    public List<Speciality> getSpecialties() {
        return specialityRepository.findAll();
    }
    public Speciality getSpeciality(Long id) {
        Optional<Speciality> byId = specialityRepository.findById(id);
        if(byId.isEmpty()) throw new IllegalStateException("Speciality not into records");
        return byId.get();
    }
    @Transactional
    public void addPatient(Long specialityId, Long patientId, String date) {
        Optional<Speciality> byId = specialityRepository.findById(specialityId);
        if(byId.isEmpty()) throw new IllegalStateException("Speciality not into records");
        Speciality speciality = byId.get();
        Patient patient = patientService.addPatientDate(patientId, date);
        patient.setSpeciality(speciality);
    }
    /*@Autowired


    @Override public List<SpecialityDTO> getAllSpeciality() {
        return specialityRepository.findAll()
                .stream()
                .map(this::convertSpecialityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SpecialityDTO createSpeciality(SpecialityDTO medicalSpecialityDTO) {
        Speciality speciality = new Speciality();
        speciality.setName(medicalSpecialityDTO.getName());
        speciality.setPhysicianInCharge(medicalSpecialityDTO.getPhysicianInCharge());
        return convertSpecialityToDTO(specialityRepository.save(speciality));
    }
    @Override
    public boolean deleteSpeciality(SpecialityDTO specialityDTO){
        Speciality speciality = specialityRepository.findById(specialityDTO.getSpecialityId()).get();
        if(speciality.getPatients().size() == 0){
            specialityRepository.deleteById(speciality.getId());
            return true;
        }
        return false;
    }

    @Transactional
    public void updateName(Long id, String name){
        specialityRepository.updateName(id, name);
    }

    @Transactional
    public void updateSpeciality(Long id, String name, String physicianInCharge){
        specialityRepository.updateMedicalSpeciality(id, name, physicianInCharge);
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
    private SpecialityDTO convertSpecialityToDTO(Speciality speciality){
        SpecialityDTO SpecialityDTO = new SpecialityDTO();
        SpecialityDTO.setSpecialityId(speciality.getId());
        SpecialityDTO.setName(speciality.getName());
        SpecialityDTO.setPhysicianInCharge(speciality.getPhysicianInCharge());
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient :speciality.getPatients() ) {
            patientDTOS.add(convertPatientToDTO(patient));
        }
        SpecialityDTO.setPatients(patientDTOS);
        return SpecialityDTO;
    }*/
}
