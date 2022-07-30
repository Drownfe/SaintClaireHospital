package com.sofkau.saintclaireHospital.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Patients")
@Table(name = "patients")
public class Patient {

    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    private Long id;
    @Column(updatable = false, nullable = false, unique = true)
    private Long dni;
    @Column(updatable = false, length = 45, nullable = false)
    private String name;
    @Column(updatable = false, nullable = false)
    private Integer age;

    @Column(columnDefinition = "TEXT")
    private String datesAppointments;
    private Long numberOfAppointments;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    @JsonBackReference
    private Speciality speciality;
    public Patient() {
    }
    public Patient(Long dni, String name, Integer age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.numberOfAppointments = 0L;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Long getDni() {
        return dni;
    }

    public List<String> getDatesAppointments() {
        String strDates = datesAppointments;
        if(strDates == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(List.of(strDates.split(";")));
    }
    public void setDatesAppointments(String date) {
        List<String> dates = getDatesAppointments();
        dates.add(date);
        this.datesAppointments = String.join(";", dates);
    }
    public Long getNumberOfAppointments() {
        return numberOfAppointments;
    }
    public void setNumberOfAppointments(Long numberOfAppointments) {
        this.numberOfAppointments = numberOfAppointments;
    }
    public Speciality getSpeciality() {
        return speciality;
    }
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}

