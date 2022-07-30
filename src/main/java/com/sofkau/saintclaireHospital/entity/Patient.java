package com.sofkau.saintclaireHospital.entity;
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
    @Column(updatable = false, nullable = false)
    private Long dni;
    @Column(updatable = false, length = 45, nullable = false)
    private String name;
    @Column(updatable = false, nullable = false)
    private Integer age;

    @Column(columnDefinition = "TEXT")
    private String datesAppointments;
    @Transient
    private List<String> datesAppointmentsList = new ArrayList<>();
    private Long numberOfAppointments;
    public Patient() {
    }
    public Patient(Long dni, String name, Integer age) {
        this.dni = dni;
        this.name = name;
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Long getDni() {
        return dni;
    }
    public void setDni(Long dni) {
        this.dni = dni;
    }
    public List<String> getDatesAppointmentsList() {
        return datesAppointmentsList;
    }
    public void setDatesAppointmentsList(List<String> datesAppointmentsList) {
        this.datesAppointmentsList = datesAppointmentsList;
    }
    public Long getNumberOfAppointments() {
        return numberOfAppointments;
    }
    public void setNumberOfAppointments(Long numberOfAppointments) {
        this.numberOfAppointments = numberOfAppointments;
    }
    public String getDatesAppointments() {
        return datesAppointments;
    }
    public void setDatesAppointments(String datesAppointments) {
        this.datesAppointments = datesAppointments;
    }
}

