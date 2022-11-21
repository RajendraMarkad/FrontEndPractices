package com.cognizant.ptracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ptracker.model.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer> {

	Patient findBypatientIdAndPassword(String patientId, String password);
	
	@Query("SELECT p from Patient p where p.patientId=?1")
	Patient findByPatientId(String patientId);
	
	@Query("SELECT p from Patient p where p.p_Id=?1")
	Patient findByPatientId(Integer pId);
	
	@Query("SELECT p FROM Patient p")
	public List<Patient> getPatients();

	@Query("SELECT p FROM Patient p WHERE p.status='pending'")
	public List<Patient> getPendingPatients();
	
	@Query("SELECT p FROM Patient p WHERE p.p_Id=?1")
	public Patient approveOrDeny(Integer p_Id);

	@Query("SELECT p from Patient p where p.patientId=?1")
	Patient getPatient(String name);
	
	@Query("SELECT p from Patient p where p.d_Id=?1")
	public List<Patient> getDPatients(Integer d_Id);

	@Query("SELECT p from Patient p where p.testResult='Raised'")
	public List<Patient> getPatientStatus();
	
	
	
}




