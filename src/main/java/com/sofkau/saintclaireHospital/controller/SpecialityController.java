package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.Services.SpecialityService;
import com.sofkau.saintclaireHospital.dto.PatientDTO;
import com.sofkau.saintclaireHospital.dto.SpecialityDTO;
import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.utility.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialtyService;

    @GetMapping
    public List<Speciality> getSpecialties() {
        return specialtyService.getSpecialties();
    }

    @PutMapping(path = "{specialityId}")
    public void addPatient(
            @PathVariable("specialityId") Long specialityId,
            @RequestParam(name = "patientId") Long patientId,
            @RequestParam(name = "date") String date
    ) {
        specialtyService.addPatient(specialityId, patientId, date);
    }

    /*private Response response = new Response();
    private HttpStatus httpStatus = HttpStatus.OK;

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("speciality")
    public List<SpecialityDTO> getAllSpecialities() {
        return specialityService.getAllSpeciality();
    }

    @PostMapping("create/speciality")
    public ResponseEntity<Response> createSpeciality(@RequestBody SpecialityDTO SpecialityDTO){
        response.restart();
        try {
            response.data = specialityService.createSpeciality(SpecialityDTO);
            httpStatus = HttpStatus.CREATED;
        } catch (ConstraintViolationException exception){
            response.data = exception.getCause();
            response.message = exception.getMessage();
            response.error = true;
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(response, httpStatus);
    }
    @DeleteMapping("delete/speciality")
    public ResponseEntity<Response> deleteSpeciality(@RequestBody SpecialityDTO medicalSpecialityDTO){
        response.restart();
        boolean state = specialityService.deleteSpeciality(medicalSpecialityDTO);
        if(state){
            response.data = medicalSpecialityDTO;
            response.message = "successfully deleted";
            httpStatus = HttpStatus.OK;
        } else {
            response.data = medicalSpecialityDTO;
            response.message = "Cannot be deleted";
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(response, httpStatus);
    }

    @PatchMapping(path = "update/name/speciality")
    public ResponseEntity<Response> updateName(@RequestBody SpecialityDTO specialityDTO){
        response.restart();
        try {
            specialityService.updateName(specialityDTO.getSpecialityId(), specialityDTO.getName());
            response.data = specialityDTO.getName();
            response.message = "successfully updated";
            httpStatus = HttpStatus.OK;
        } catch(Exception exception){
            response.data = exception.getCause();
            response.message = exception.getMessage();
            response.error = true;
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(response, httpStatus);
    }

    @PutMapping(path = "update/speciality")
    public ResponseEntity<Response> updateSpeciality(@RequestBody SpecialityDTO specialityDTO){
        response.restart();
        try {
            specialityService.updateSpeciality(specialityDTO.getSpecialityId(),
                    specialityDTO.getName(), specialityDTO.getPhysicianInCharge());
            response.data = specialityDTO;
            response.message = "Updated!!!";
            httpStatus = HttpStatus.OK;
        } catch(Exception exception){
            response.data = exception.getCause();
            response.message = exception.getMessage();
            response.error = true;
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(response, httpStatus);
    }


    private Patient convertDTOToPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAge(patientDTO.getAge());
        patient.setDni(patientDTO.getDni());
        patient.setDatesOfAppointments(patientDTO.getDatesOfAppointments());
        patient.setFkSpecialityId(patientDTO.getFkSpecialityId());
        return patient;
    }*/
}
