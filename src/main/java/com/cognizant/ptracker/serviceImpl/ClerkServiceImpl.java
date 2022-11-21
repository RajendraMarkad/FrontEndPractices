package com.cognizant.ptracker.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ptracker.daoImpl.ClerkDaoImpl;
import com.cognizant.ptracker.daoImpl.DoctorDaoImpl;
import com.cognizant.ptracker.daoImpl.PatientDaoImpl;
import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.ClerkService;

@Service
public class ClerkServiceImpl implements ClerkService {

	@Autowired
	private ClerkDaoImpl clerkDaoImpl;
	
	@Autowired
	private DoctorDaoImpl doctorDaoImpl;
	
	@Autowired
	private PatientDaoImpl patientDaoImpl;

	@Override
	public void saveClerk(Clerk clerk) {
		
		clerkDaoImpl.save(clerk);
	}

	@Override
	public Clerk findByClerkIdAndPassword(String clerkId, String password) {
		
		return clerkDaoImpl.findByClerkIdAndPassword(clerkId, password);
		
	}

	@Override
	public Patient findByPatientId(String patientId) {
		return patientDaoImpl.findByPatientId(patientId);
	}

	@Override
	public Patient findByPatientId(Integer pId) {
		return patientDaoImpl.findByPatientId(pId);
	}

	@Override
	public void save(Patient patient) {
		patientDaoImpl.save(patient);
		
	}

	@Override
	public List<Patient> getPatients() {
		return patientDaoImpl.getPatients();
	}

	@Override
	public Doctor findBydoctorId(Integer id) {
		return doctorDaoImpl.findBydoctorId(id);
	}

	@Override
	public Patient getPatient(String name) {
		return patientDaoImpl.getPatient(name);
	}
	
	

}
