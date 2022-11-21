package com.cognizant.ptracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;

@Repository
public interface ClerkDao extends JpaRepository<Clerk, Integer> {

	Clerk findByclerkIdAndPassword(String clerkId, String password);

	Clerk findByclerkId(String clerkId);

	@Query("SELECT c FROM Clerk c WHERE c.status='pending'")
	public List<Clerk> getPendingClerk();

	@Query("SELECT c FROM Clerk c WHERE c.c_Id=?1")
	public Clerk approveOrDeny(Integer c_Id);
	
}
