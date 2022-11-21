package com.cognizant.ptracker.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.cognizant.ptracker.dao.ClerkDao;
import com.cognizant.ptracker.model.Clerk;


@Component
public class ClerkDaoImpl {

	@Autowired
	private ClerkDao clerkDao;

	public void save(Clerk clerk) {
		clerkDao.save(clerk);
	}

	public Clerk findByClerkIdAndPassword(String clerkId, String password) {
		return clerkDao.findByclerkIdAndPassword(clerkId, password);
	}

	public Clerk findByClerkId(String clerkId) {
		return clerkDao.findByclerkId(clerkId);
	}

	public List<Clerk> getPendingClerk() {
		return clerkDao.getPendingClerk();
	}

	public Clerk approveOrDeny(Integer c_Id)
	{
		return clerkDao.approveOrDeny(c_Id);
	}
}
