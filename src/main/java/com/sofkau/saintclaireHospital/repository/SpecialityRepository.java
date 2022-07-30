package com.sofkau.saintclaireHospital.repository;

import com.sofkau.saintclaireHospital.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    /*@Modifying
    @Query("UPDATE MedicalSpeciality sp SET sp.name = :name " +
            "WHERE sp.id = :id")
    public void updateName(
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );

    @Modifying
    @Query("UPDATE MedicalSpeciality sp SET sp.physicianInCharge = :physicianInCharge " +
            "WHERE sp.id = :id")
    public void updatePhysicianInCharge(
            @Param(value = "id") Long id,
            @Param(value = "physicianInCharge") String physicianInCharge
    );

    @Modifying
    @Query("UPDATE MedicalSpeciality sp SET sp.name = :name, sp.physicianInCharge = :physicianInCharge " +
            "WHERE sp.id = :id")
    public void updateMedicalSpeciality(
            @Param(value = "id") Long id,
            @Param(value = "name") String name,
            @Param(value = "physicianInCharge") String physicianInCharge
    );*/
}
