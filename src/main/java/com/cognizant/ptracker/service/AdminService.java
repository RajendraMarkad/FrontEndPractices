package com.cognizant.ptracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.ptracker.model.Admin;
import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;

@Service
public interface AdminService {

	public Admin findByAdminIdAndPassword(int adminId,String password);
	//public List<Patient> getPatients(Integer d_Id);
	public List<Patient> getPendingPatients();
	public List<Doctor> getPendingDoctors();
	public List<Clerk> getPendingClerk();
	public Patient acceptedPatient(Integer p_Id);
	public Patient deniedPatient(Integer p_Id);
	public Doctor acceptedDoctor(Integer d_Id);
	public Doctor deniedDoctor(Integer d_Id);
	public Clerk deniedClerk(Integer c_Id);
	public Clerk acceptedClerk(Integer c_Id);
	public Patient findByPatientId(String patientId);
	public List<Patient> getPatients();
	public Patient findByPatientId(Integer pId);
	public void save(Patient patient);
	public Patient updateTest(Integer pId);
	public List<Patient> getPatientStatus();
}
