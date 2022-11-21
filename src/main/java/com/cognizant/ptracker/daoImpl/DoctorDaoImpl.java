package com.cognizant.ptracker.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.ptracker.dao.DoctorDao;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;

@Component
public class DoctorDaoImpl {

	@Autowired
	private DoctorDao doctorDao;

	public void save(Doctor doctor) {
		doctorDao.save(doctor);
	}

	public Doctor findByDoctorIdAndPassword(String doctorId, String password) {
		return doctorDao.findBydoctorIdAndPassword(doctorId, password);
	}

	public Doctor findBydoctorId(Integer doctorId) {
		return doctorDao.findBydoctorId(doctorId);
	}

	public List<Doctor> getPendingDoctors() {
		return doctorDao.getPendingDoctors();
	}

	public Doctor approveOrDeny(Integer d_Id)
	{
		return doctorDao.approveOrDeny(d_Id);
	}


}
