package com.cognizant.ptracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.ptracker.exceptions.DoctorException;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.DoctorService;
import com.cognizant.ptracker.service.PatientService;

@Controller
public class DoctorController {

	private static final Logger logger  = Logger.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	Integer doctor_Id;
	@GetMapping("/doctorReg")
	public String doctorReg(@ModelAttribute("doctor") Doctor doctor) {
		return "doctorReg";
	}

	@PostMapping("/regSucess")
	public String saveDoc(@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "doctorReg";
		}
		model.put("dId", doctor.getDoctorId());
		doctorService.saveDoctor(doctor);
		return "regSucess";
	}

	@GetMapping("/doctorLogin")
	public String loginDoctor(@ModelAttribute("doctor") Doctor doctor) {
		return "doctorLogin";

	}

	@PostMapping("/doctorHome")
	public String loginAuthentication(@RequestParam("doctorId") String doctorId,
			@RequestParam("password") String password, HttpSession session, ModelMap model) throws DoctorException {
		Doctor doctor = doctorService.findBydoctorIdAndPassword(doctorId, password);
		if (!(ObjectUtils.isEmpty(doctor))) {
			if ((doctor.getStatus().equalsIgnoreCase("pending")) || (doctor.getStatus().equalsIgnoreCase("Denied"))) {
				model.addAttribute("msg", "Admin has not accepted your registration");
				return "doctorLogin";
			} else {
				session.setAttribute("doctorId", doctorId);
				logger.info("Doctor Login Successfull");
				logger.debug(session.getAttribute("doctorId"));
				model.put("doctorname", doctor.getFirstName());
				doctor_Id = doctor.getD_Id();
				return "doctorHome";
			}
		} else {
			 logger.info("Invalid Username or Password - Doctor"); 
	    	 throw new DoctorException();
		}

	}

	@GetMapping("/doctorhHome")
	public String gotoHome()
	{
		return "doctorHome";
	}
	
	@GetMapping("/maintainHist")
	public String updateRecords(Doctor doctor, Model m) {
		logger.debug(doctor_Id);
		List<Patient> patients = doctorService.getDPatient(doctor_Id);
		logger.debug(patients);
		m.addAttribute("patientsList", patients);
		return "updaterecords";
	}

	@GetMapping("/medicalReport")
	public String patientRecord(@ModelAttribute("patient") Patient patient,Model map) {
		
		return "medicalRecord";
	}

	@PostMapping("/medicalReport")
	public String patientReport(@RequestParam("patientId") String patientId,@RequestParam("appointmentDate") String appointmentDate,
			@RequestParam("prescription") String prescription, ModelMap model) {
		Patient patient = doctorService.findByPatientId(patientId);
		if(patient!=null)
		{	
		patient.setPrescription(prescription);
		patient.setAppointmentDate(appointmentDate);
		patient.setD_Id(doctor_Id);
		patientService.savePatient(patient);
		System.out.println(patient);
		model.addAttribute("patient", patient);
		return "updateSucess";
		}
		return "errorMessage";

	}
	@GetMapping("/patientTest/{pId}")
	public String patientTest(@PathVariable Integer pId,Model model)
	{
		Patient patients = doctorService.approveOrDeny(pId);
		model.addAttribute("patientId", patients.getPatientId());
		model.addAttribute("firstName", patients.getFirstName());
		model.addAttribute("Request", patients.getTestRequest());
		model.addAttribute("Result", patients.getTestResult());
		return "TestPatient";
		
	}
	@GetMapping("/updateDiet")
	public String patientRecord2(@ModelAttribute("patient") Patient patient)
	{
		return "updateDietExer";
	}
	
	@PostMapping("/updateDiet")
	public String patientReport3(@RequestParam("patientId") String patientId,@RequestParam("diet") String diet,@RequestParam("execrise") String execrise,ModelMap model,Doctor doctor) {
		Patient patient=doctorService.findByPatientId(patientId);	
		patient.setDiet(diet);
		patient.setExecrise(execrise);
		patient.setD_Id(doctor_Id);
			patientService.savePatient(patient);
		model.addAttribute("patient",patient);
		return "updateSucess";
		
	}
	@GetMapping("/patientTests")
	public String patientTest(Model model)
	{
		List<Patient> patients = doctorService.getDPatient(doctor_Id);
		model.addAttribute("patientList", patients);
		return "patientTests";
	}
	@GetMapping("/update/{pId}")
	public String updatepatientRecord(@PathVariable Integer pId,@ModelAttribute("patient") Patient patient,ModelMap map) {
		Patient patients = doctorService.approveOrDeny(pId);
		map.put("name", patients.getPatientId());
		return "medicalRecord";
	}
	@PostMapping("/update/{pId}")
	public String updatePatient(@PathVariable String patientId,@RequestParam("appointmentDate") String appointmentDate,
			@RequestParam("prescription") String prescription, ModelMap model) {
		Patient patient = doctorService.findByPatientId(patientId);
		if(patient!=null)
		{	
		patient.setPrescription(prescription);
		patient.setAppointmentDate(appointmentDate);
		patient.setD_Id(doctor_Id);
		patientService.savePatient(patient);
		logger.debug(patient);
		model.addAttribute("patient", patient);
		return "updateSucess";
		}
		return "errorMessage";

	}

}
