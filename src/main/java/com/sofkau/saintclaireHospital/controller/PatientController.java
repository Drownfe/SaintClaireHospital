package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.exception.ResourceNotFoundException;
import com.sofkau.saintclaireHospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id: " + id ));
        return ResponseEntity.ok(patient);
    }
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient patientDetails){
        Patient updatePatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id:" + id ));
        updatePatient.setDni      (patientDetails.getDni());
        updatePatient.setFirstName(patientDetails.getFirstName());
        updatePatient.setLastName (patientDetails.getLastName());
        updatePatient.setAge      (patientDetails.getAge());
        patientRepository.save(updatePatient);
        return ResponseEntity.ok(updatePatient);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id:" + id ));
        patientRepository.delete(patient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
