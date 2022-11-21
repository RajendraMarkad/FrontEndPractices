package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cognizant.ptracker.*")
public class PatientTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientTrackingApplication.class, args);
	}

}
