package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.Services.SpecialityService;
import com.sofkau.saintclaireHospital.dto.Mapper;
import com.sofkau.saintclaireHospital.dto.SpecialityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialtyService;
    @GetMapping
    public List<SpecialityDTO> getSpecialties() {
        return specialtyService.getSpecialties()
                .stream()
                .map(Mapper::createSpecialityDTO)
                .toList();
    }
    @PutMapping(path = "{specialityId}")
    public SpecialityDTO addPatient(
            @PathVariable("specialityId") Long specialityId,
            @RequestParam(name = "patientId") Long patientId,
            @RequestParam(name = "date") String date
    ) {
        return Mapper.createSpecialityDTO(
                specialtyService.addPatient(specialityId, patientId, date));
        }
}



