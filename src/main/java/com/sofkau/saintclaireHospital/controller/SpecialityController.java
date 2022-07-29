package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.Services.SpecialityService;
import com.sofkau.saintclaireHospital.dto.SpecialityDTO;
import com.sofkau.saintclaireHospital.utility.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SpecialityController {

    private Response response = new Response();
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
}
