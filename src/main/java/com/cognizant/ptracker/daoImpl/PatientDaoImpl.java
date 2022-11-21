package com.cognizant.ptracker.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.ptracker.dao.PatientDao;
import com.cognizant.ptracker.model.Patient;

@Component
public class PatientDaoImpl {

	@Autowired
	private PatientDao patientDao;

	public void save(Patient patient) {
		patientDao.save(patient);
	}

	public Patient findByPatientIdAndPassword(String patientId, String password) {
		return patientDao.findBypatientIdAndPassword(patientId, password);
	}

	public Patient findByPatientId(String patientId) {
		return patientDao.findByPatientId(patientId);
	}
	
	public Patient findByPatientId(Integer pId) {
		return patientDao.findByPatientId(pId);
	}
	
	public List<Patient> getPatients()
	{
		return patientDao.getPatients();
	}
	public List<Patient> getPendingPatients()
	{
		return patientDao.getPendingPatients();
	}
	public Patient approveOrDeny(Integer p_Id)
	{
		return patientDao.approveOrDeny(p_Id);
	}

	public Patient getPatient(String name) {
		return patientDao.getPatient(name);
	}
	public List<Patient> getDPatient(Integer d_Id)
	{
		return patientDao.getDPatients(d_Id);
	}

	public List<Patient> getPatientStatus() {
		return patientDao.getPatientStatus();
	}
}
