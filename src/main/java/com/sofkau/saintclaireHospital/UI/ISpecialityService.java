package com.sofkau.saintclaireHospital.UI;

import com.sofkau.saintclaireHospital.dto.SpecialityDTO;

import java.util.List;

public interface ISpecialityService {
    List<SpecialityDTO> getAllSpeciality();
    SpecialityDTO createSpeciality(SpecialityDTO medicalSpecialityDTO);
    boolean deleteSpeciality(SpecialityDTO medicalSpecialityDTO);
}
