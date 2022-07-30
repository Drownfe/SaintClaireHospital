package com.sofkau.saintclaireHospital.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sofkau.saintclaireHospital.exception.InvalidRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
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
    public Patient(Long id,Long dni, String name, Integer age, String datesAppointments, Long numberOfAppointments) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.age = age;
        this.datesAppointments = datesAppointments;
        this.numberOfAppointments = numberOfAppointments;
    }
    public Patient(Long dni, String name, Integer age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
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
        boolean contains = dates.contains(date);
        if(!contains) dates.add(date);
        this.datesAppointments = String.join(";", dates);
    }
    public Long getNumberOfAppointments() {
        return (long) getDatesAppointments().size();
    }
    public void setNumberOfAppointments(Long numberOfAppointments) {
        if(numberOfAppointments <= 0) this.datesAppointments = null;
        else cutDatesAppointments(numberOfAppointments);
        this.numberOfAppointments = numberOfAppointments;
    }
    public void setNumberOfAppointments(Integer newSize) {
        if(newSize <= 0) this.datesAppointments = null;
        else cutDatesAppointmentsReverse(newSize);
        this.numberOfAppointments = (long ) newSize;
    }
    private void cutDatesAppointments(Long numberOfAppointments) {
        List<String> dates = getDatesAppointments();
        if(numberOfAppointments > dates.size()) throw new InvalidRequest("That size exceeds the current number of appointments");
        dates = dates.subList(0, Math.toIntExact(numberOfAppointments));
        this.datesAppointments = String.join(";", dates);
    }

    private void cutDatesAppointmentsReverse(Integer newSize) {
        List<String> dates = getDatesAppointments();
        if(newSize > dates.size()) throw new InvalidRequest("That size exceeds the current number of appointments");
        Collections.reverse(dates);
        dates = dates.subList(0, newSize);
        Collections.reverse(dates);
        this.datesAppointments = String.join(";", dates);
    }
    public Speciality getSpeciality() {
        return speciality;
    }
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}

