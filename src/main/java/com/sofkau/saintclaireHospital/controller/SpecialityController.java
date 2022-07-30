package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.Services.SpecialityService;
import com.sofkau.saintclaireHospital.dto.Mapper;
import com.sofkau.saintclaireHospital.dto.SpecialityDTO;
import com.sofkau.saintclaireHospital.exception.InvalidRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;
    @GetMapping
    public ResponseEntity<List<SpecialityDTO>> getSpecialities() {
        return new ResponseEntity<>(
                specialityService.getSpecialities()
                        .stream()
                        .map(Mapper::createSpecialityDTO)
                        .toList(),
                HttpStatus.OK
        );
    }
    @GetMapping(path = "{specialtyId}")
    public ResponseEntity<SpecialityDTO> getSpecialty(@PathVariable(name = "specialtyId") Long id) {
        return new ResponseEntity<>(
                Mapper.createSpecialityDTO(
                        specialityService.getSpeciality(id)
                ),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<SpecialityDTO> createSpeciality(@RequestBody SpecialityDTO speciality) {
        if (
                speciality.name == null ||
                        speciality.physicianInCharge == null
    ) throw new InvalidRequest("Specialty & Physician name are required for specialty creation");
        return new ResponseEntity<>(
                Mapper.createSpecialityDTO(
                        specialityService.createSpeciality(speciality)
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update/{specialtyId}")
    public ResponseEntity<SpecialityDTO> updateSpeciality(
            @PathVariable("specialtyId") Long specialtyId,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "pic", required = false) String physicianInCharge
    ) {
        return new ResponseEntity<>(
                Mapper.createSpecialityDTO(
                        specialityService.updateSpeciality(specialtyId, name, physicianInCharge)
                ),
                HttpStatus.ACCEPTED
        );
    }
    @PutMapping(path = "{specialtyId}")
    public ResponseEntity<SpecialityDTO> addPatient(
            @PathVariable("specialtyId") Long specialtyId,
            @RequestParam(name = "patientId") Long patientId,
            @RequestParam(name = "date") String date
    ) {
        return new ResponseEntity<>(
                Mapper.createSpecialityDTO(
                        specialityService.addPatient(specialtyId, patientId, date)
                ),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping(path = "{specialtyId}")
    public ResponseEntity<SpecialityDTO> deleteSpeciality(@PathVariable("specialtyId") Long specialtyId) {
        return new ResponseEntity<>(
                Mapper.createSpecialityDTO(
                        specialityService.deleteSpeciality(specialtyId)
                ),
                HttpStatus.OK
        );
    }
}



