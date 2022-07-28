package com.sofkau.saintclaireHospital.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Patients")
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long id;  //PK for user patient in db

    @Column(name = "dni")
    private String dni;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name ="age")
    private int age;

    @Column(name = "numer_of_appointments")
    private Long numberOfAppointments;

}
