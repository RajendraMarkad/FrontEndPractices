package com.cognizant.ptracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ptracker.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

	Admin findByadminIdAndPassword(int adminId,String password);
}
