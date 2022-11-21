package com.cognizant.ptracker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ptracker.daoImpl.PatientDaoImpl;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDaoImpl patientDaoImpl;
	
	@Override
	public void savePatient(Patient patient) {
		
		patientDaoImpl.save(patient);
		
	}

	@Override
	public Patient findByPatientIdAndPassword(String patientId, String password) {
		
		return patientDaoImpl.findByPatientIdAndPassword(patientId, password);
	}

	@Override
	public Patient findByPatientId(String patientId) {
		
		return patientDaoImpl.findByPatientId(patientId);
		
	}

	@Override
	public Patient getPatient(String name) {
	  return patientDaoImpl.getPatient(name);
	}

	

}
