package com.cognizant.ptracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;

@Service
public interface ClerkService {

	public void saveClerk(Clerk clerk);

	public Clerk findByClerkIdAndPassword(String clerkId, String password);

	public Patient findByPatientId(String patientId);

	public Patient findByPatientId(Integer pId);

	public void save(Patient patient);

	public List<Patient> getPatients();

	public Doctor findBydoctorId(Integer id);

	public Patient getPatient(String name);

}
