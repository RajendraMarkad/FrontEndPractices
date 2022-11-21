package com.cognizant.ptracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;
@Service
public interface DoctorService {
	public void saveDoctor(Doctor doctor);

	Doctor findBydoctorIdAndPassword(String doctorId, String password);
	
	public Patient findByPatientId(String patientId);
	public List<Patient> getPatients();
	public List<Patient> getDPatient(Integer d_Id);
	public Patient approveOrDeny(Integer p_Id);

	public Doctor findBydoctorId(Integer id);
	
}
