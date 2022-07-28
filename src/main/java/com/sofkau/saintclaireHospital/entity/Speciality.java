package com.sofkau.saintclaireHospital.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "MedicalSpeciality")
@Table(name = "medical_speciality")
@Data

public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "speciality_id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "physician_in_charge")
    private String physicianInCharge;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Patient> patients = new ArrayList<>();
}
