package com.sofkau.saintclaireHospital.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Patients")
@Table(name = "patients")
public class Patient {

    private Long fkSpecialityId;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "patient_id", nullable = false)
    private Long id;  //PK for user patient in db

    @Column(name = "dni",nullable = false)
    private Long dni;

    @Column(name = "first_name",nullable = false,length = 50)
    private String name;

    @Column(name ="age", nullable = false)
    private int age;

    @Column(name = "number_of_appointments")
    private Long numberOfAppointments;

    @Column(name = "dates_of_appointments")
    private String datesOfAppointments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age && Objects.equals(id, patient.id) && Objects.equals(name, patient.name)
                && Objects.equals(dni, patient.dni) && Objects.equals(numberOfAppointments, patient.numberOfAppointments)
                && Objects.equals(fkSpecialityId, patient.fkSpecialityId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, dni, numberOfAppointments, fkSpecialityId);
    }

}
