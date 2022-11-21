package com.cognizant.ptracker.service;


import org.springframework.stereotype.Service;

import com.cognizant.ptracker.model.Patient;

@Service
public interface PatientService {

	public void savePatient(Patient patient);
	public Patient findByPatientIdAndPassword(String patientId, String password);
	public Patient findByPatientId(String patientId);
	public Patient getPatient(String name);
	
}
