package com.sofkau.saintclaireHospital.configuration;

import com.sofkau.saintclaireHospital.entity.Patient;
import com.sofkau.saintclaireHospital.entity.Speciality;
import com.sofkau.saintclaireHospital.repository.PatientRepository;
import com.sofkau.saintclaireHospital.repository.SpecialityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class HospitalConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowCredentials(false)
                .maxAge(-1);
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
    @Bean
    CommandLineRunner commandLineRunner(
            SpecialityRepository repository
    ) {
        return args -> {
            List<Speciality> specialties = new ArrayList<>(Arrays.asList(
                    new Speciality("Surgery "          , "Marta Gonzalez"  ),
                    new Speciality("Nutrition "        , "Jose Jaramillo"  ),
                    new Speciality("Dermatology "      , "Camilo Martinez" ),
                    new Speciality("Pediatrics "       , "Manuel Figueroa" ),
                    new Speciality("Ophthalmology "    , "Camila Restrepo" ),
                    new Speciality("General Medicine " , "Estefania Suarez")));
            repository.saveAll(specialties);
        };
    }
    @Bean
    CommandLineRunner commandLineRunner2(
            PatientRepository repository
    ) {
        return args -> {
            List<Patient> patients = new ArrayList<>(Arrays.asList(
                    new Patient(1035440580L  , "Juan Hernandez"  , 23),
                    new Patient(21831299L    , "Maria Palacio"   , 58),
                    new Patient(98450861L    , "Carlos Tobon"    , 55),
                    new Patient(98080150520L , "Felipe Suarez"   , 35),
                    new Patient(895845872L   , "Tomas Jaramillo" , 27)));
            repository.saveAll(patients);
        };
    }
}
