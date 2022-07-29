package com.sofkau.saintclaireHospital.controller;

import com.sofkau.saintclaireHospital.Services.SpecialityService;
import com.sofkau.saintclaireHospital.dto.SpecialityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

        @GetMapping("speciality")
        public List<SpecialityDTO> getAllSpecialities() {
            return SpecialityService.getAllSpeciality();
        }

        @PostMapping("create/speciality")
        public SpecialityDTO createSpeciality(@RequestBody SpecialityDTO medicalSpecialityDTO) {
            return SpecialityService.createSpeciality(medicalSpecialityDTO);
        }
}
