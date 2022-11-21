package com.cognizant.ptracker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ptracker.daoImpl.AdminDaoImpl;
import com.cognizant.ptracker.daoImpl.ClerkDaoImpl;
import com.cognizant.ptracker.daoImpl.DoctorDaoImpl;
import com.cognizant.ptracker.daoImpl.PatientDaoImpl;
import com.cognizant.ptracker.model.Admin;
import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDaoImpl adminDaoImpl;

	@Autowired
	private PatientDaoImpl patientDaoImpl;

	@Autowired
	private DoctorDaoImpl doctorDaoImpl;

	@Autowired
	private ClerkDaoImpl clerkDaoImpl;

	@Override
	public Admin findByAdminIdAndPassword(int adminId, String password) {

		return adminDaoImpl.findByAdminIdAndPassword(adminId, password);
	}

	public List<Patient> getPendingPatients() {
		return patientDaoImpl.getPendingPatients();
	}

	/*
	 * @Override public List<Patient> getPatients() { // TODO Auto-generated method
	 * stub return patientDaoImpl.getPatients(); }
	 */

	@Override
	public List<Doctor> getPendingDoctors() {

		return doctorDaoImpl.getPendingDoctors();
	}

	@Override
	public List<Clerk> getPendingClerk() {

		return clerkDaoImpl.getPendingClerk();
	}

	@Override
	public Patient acceptedPatient(Integer p_Id) {
		Patient patient = patientDaoImpl.approveOrDeny(p_Id);
		patient.setStatus("Approved");
		patientDaoImpl.save(patient);
		return patient;
	}

	
	@Override
	public Patient deniedPatient(Integer p_Id) {
		Patient patient = patientDaoImpl.approveOrDeny(p_Id);
		patient.setStatus("Denied");
		patientDaoImpl.save(patient);
		return patient;
	}

	@Override
	public Doctor acceptedDoctor(Integer d_Id) {
		Doctor doctor = doctorDaoImpl.approveOrDeny(d_Id);
		doctor.setStatus("Approved");
		doctorDaoImpl.save(doctor);
		return doctor;
	}
	
	@Override
	public Doctor deniedDoctor(Integer d_Id) {
		Doctor doctor = doctorDaoImpl.approveOrDeny(d_Id);
		doctor.setStatus("Denied");
		doctorDaoImpl.save(doctor);
		return doctor;
	}
	
	@Override
	public Clerk acceptedClerk(Integer c_Id) {
		Clerk clerk = clerkDaoImpl.approveOrDeny(c_Id);
		clerk.setStatus("Approved");
		clerkDaoImpl.save(clerk);
		return clerk;
	}
	
	@Override
	public Clerk deniedClerk(Integer c_Id) {
		Clerk clerk = clerkDaoImpl.approveOrDeny(c_Id);
		clerk.setStatus("Denied");
		clerkDaoImpl.save(clerk);
		return clerk;
	}

	@Override
	public Patient findByPatientId(String patientId) {
		return patientDaoImpl.findByPatientId(patientId);
	}

	@Override
	public List<Patient> getPatients() {
		return patientDaoImpl.getPatients();
	}

	@Override
	public Patient findByPatientId(Integer pId) {
		return patientDaoImpl.findByPatientId(pId);
	}

	public void save(Patient patient) 
	{
		patientDaoImpl.save(patient);
	}

	@Override
	public Patient updateTest(Integer pId) {
		return patientDaoImpl.approveOrDeny(pId);
	}

	@Override
	public List<Patient> getPatientStatus() {
		return patientDaoImpl.getPatientStatus();
	}
	
	

}
