package com.sofkau.saintclaireHospital.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "MedicalSpeciality")
@Table(name = "medical_speciality")
public class Speciality {
    @Id
    @SequenceGenerator(
            name = "specialty_sequence",
            sequenceName = "specialty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "specialty_sequence"
    )
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 45)
    private String physicianInCharge;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "speciality",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Patient> patients = new HashSet<>();
    public Speciality() {
    }
    public Speciality(Long id, String name, String physicianInCharge) {
        this.id = id;
        this.name = name;
        this.physicianInCharge = physicianInCharge;
    }
    public Speciality(String name, String physicianInCharge) {
        this.name = name;
        this.physicianInCharge = physicianInCharge;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhysicianInCharge() {
        return physicianInCharge;
    }
    public void setPhysicianInCharge(String physicianInCharge) {
        this.physicianInCharge = physicianInCharge;
    }
    public Set<Patient> getPatients() {
        return patients;
    }
}
