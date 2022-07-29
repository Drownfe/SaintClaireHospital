package com.sofkau.saintclaireHospital;

import com.sofkau.saintclaireHospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaintClaireHospitalApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SaintClaireHospitalApplication.class, args);

	}

	@Autowired
	private PatientRepository patientRepository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("********************************");
		System.out.println("\t SAINT CLAIRE HOSPITAL");
		System.out.println("********************************");
		System.out.println();

	}
}
