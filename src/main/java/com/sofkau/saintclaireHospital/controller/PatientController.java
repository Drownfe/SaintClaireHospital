package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.Services.PatientService;
import com.sofkau.saintclaireHospital.dto.PatientDTO;
import com.sofkau.saintclaireHospital.utility.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    private PatientService patientService;
    private Response response = new Response();
    private HttpStatus httpStatus = HttpStatus.OK;
    @PostMapping("create/patient")
    public ResponseEntity<Response> createPatient(@RequestBody PatientDTO patientDTO){
        response.restart();
        try {
            response.data = patientService.createPatient(patientDTO);
            httpStatus = HttpStatus.CREATED;
        } catch (ConstraintViolationException exception){
            response.data = exception.getCause();
            response.message = exception.getMessage();
            response.error = true;
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(response, httpStatus);
    }

}
