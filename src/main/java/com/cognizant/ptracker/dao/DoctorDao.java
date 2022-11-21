package com.cognizant.ptracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;


@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {

	Doctor findBydoctorIdAndPassword(String doctorId, String password);

	@Query("SELECT d FROM Doctor d WHERE d.d_Id=?1")
	Doctor findBydoctorId(Integer doctorId);
	
	
	@Query("SELECT d FROM Doctor d WHERE d.status='pending'")
	public List<Doctor> getPendingDoctors();
	
	@Query("SELECT d FROM Doctor d WHERE d.d_Id=?1")
	public Doctor approveOrDeny(Integer d_Id);
	
	
}
