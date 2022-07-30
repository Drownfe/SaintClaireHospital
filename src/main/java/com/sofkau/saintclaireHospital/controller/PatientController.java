package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.Services.PatientService;
import com.sofkau.saintclaireHospital.dto.Mapper;
import com.sofkau.saintclaireHospital.dto.PatientDTO;
import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.exception.InvalidRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping
    public List<PatientDTO> getPatients() {
        return patientService.getPatients()
                .stream()
                .map(Mapper::createPatientDTO)
                .toList();
    }
    @GetMapping(path = "{patientId}")
    public PatientDTO getPatient(@PathVariable(name = "patientId") Long id) {
        return Mapper.createPatientDTO(
                patientService.getPatient(id)
        );
    }
    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO patient) {
        if(
                patient.dni == null ||
                patient.name == null ||
                        patient.age == null
        ) throw new InvalidRequest("name, age & identification number are required for patient creation");

        return Mapper.createPatientDTO(
                patientService.createPatient(patient)
        );
    }
    @PutMapping(path = "{patientId}")
    public PatientDTO deletePatientAppointments(
            @PathVariable(name = "patientId") Long id,
            @RequestParam(name = "newLen", defaultValue = "0") int newSize,
            @RequestParam(name = "lastOnes", required = false, defaultValue = "true") boolean reverse
    ) {
        return Mapper.createPatientDTO(
                patientService.deletePatientAppointments(id, newSize, reverse)
        );
    }

    @DeleteMapping(path = "{patientId}")
    public PatientDTO deletePatient(@PathVariable(name = "patientId") Long id) {
        return Mapper.createPatientDTO(
                patientService.deletePatient(id)
        );
    }
}
