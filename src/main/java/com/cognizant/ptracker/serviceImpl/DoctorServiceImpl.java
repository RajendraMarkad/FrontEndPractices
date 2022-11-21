package com.cognizant.ptracker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ptracker.daoImpl.DoctorDaoImpl;
import com.cognizant.ptracker.daoImpl.PatientDaoImpl;
import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDaoImpl doctorDaoImpl;
	
	@Autowired
	private PatientDaoImpl patientDaoImpl;
	
	public void saveDoctor(Doctor doctor)
	{
		doctorDaoImpl.save(doctor);
	}
	
	@Override
	public Doctor findBydoctorIdAndPassword(String doctorId, String password) {
		
		return doctorDaoImpl.findByDoctorIdAndPassword(doctorId, password);
		
	}
	
	public List<Patient> getPatients()
	{
		return patientDaoImpl.getPatients();
	}


	@Override
	public Patient findByPatientId(String patientId) {
		return patientDaoImpl.findByPatientId(patientId);
	}

	public List<Patient> getDPatient(Integer d_Id)
	{
		return patientDaoImpl.getDPatient(d_Id);
	}
	
	public Patient approveOrDeny(Integer p_Id)
	{
		return patientDaoImpl.approveOrDeny(p_Id);
	}

	@Override
	public Doctor findBydoctorId(Integer id) {
		return doctorDaoImpl.findBydoctorId(id);
	}
	
	
	
}
