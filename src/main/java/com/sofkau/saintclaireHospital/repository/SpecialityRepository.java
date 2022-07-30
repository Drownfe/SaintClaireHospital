package com.sofkau.saintclaireHospital.repository;

import com.sofkau.saintclaireHospital.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

}
