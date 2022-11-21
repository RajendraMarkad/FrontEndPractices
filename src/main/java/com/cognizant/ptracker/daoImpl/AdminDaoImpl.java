package com.cognizant.ptracker.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.ptracker.dao.AdminDao;
import com.cognizant.ptracker.model.Admin;

public class AdminDaoImpl {
	
	@Autowired
	private AdminDao adminDao;
	
	public Admin findByAdminIdAndPassword(int adminId,String password)
	{
		return adminDao.findByadminIdAndPassword(adminId, password);	
	}
}
