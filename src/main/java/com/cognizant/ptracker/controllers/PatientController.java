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

import com.cognizant.ptracker.daoImpl.PatientDaoImpl;
import com.cognizant.ptracker.exceptions.PatientException;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.PatientService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class PatientController {
    
	private static final Logger logger  = Logger.getLogger(ClerkController.class);
	
	@Autowired
	private PatientService patientService;

	@Autowired
	private PatientDaoImpl patientDaoImpl;

	@GetMapping("/patientReg")
	public String patientReg(@ModelAttribute("patient") Patient patient) {
		return "patientReg";
	}

	@PostMapping("/pregSuccess")
	public String savePat(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "patientReg";
		}
		patientService.savePatient(patient);
		return "regSucess";
	}

	@GetMapping("/patientLogin")
	public String loginPatient(@ModelAttribute("patient") Patient patient) {
		return "patientLogin";

	}

	@PostMapping("/patientHome")
	public String loginAuthentication(@RequestParam("patientId") String patientId,
			@RequestParam("password") String password, HttpSession session, ModelMap model) throws PatientException {
		Patient patient = patientService.findByPatientIdAndPassword(patientId, password);
		if (!(ObjectUtils.isEmpty(patient))) {
			if ((patient.getStatus().equalsIgnoreCase("pending")) || (patient.getStatus().equalsIgnoreCase("Denied"))) {
				model.addAttribute("msg", "Admin has not accepted your registration");
				return "patientLogin";
			} else {

				session.setAttribute("patientId", patientId);
				logger.info("Login Successfull - Patient");
				logger.debug(session.getAttribute("patientId"));
				model.put("patientname", patient.getFirstName());
				return "patientHome";
			}

		} else {
			logger.info("Invalid Username or Password - Patient"); 
	    	 throw new PatientException();
		}

	}
	@GetMapping("/forgetPatientPassword")
	public String forgetPatient(@ModelAttribute("patient") Patient patient,Model model)
	{
		return "forgetPatientPassword";
	}
	@PostMapping("/forgetPatientPassword")
	public String forgetPatientP(@ModelAttribute("patient") Patient p,@RequestParam("patientId") String patientId,@RequestParam("secretQ") String secretQ,@RequestParam("answer") String answer,Model model)
	{
		Patient patient = patientService.findByPatientId(patientId);
		logger.debug(patient.getSecretQ());
		logger.debug(patient.getAnswer());
		logger.debug(secretQ);
		logger.debug(answer);
		if(patient.getSecretQ().equalsIgnoreCase(secretQ) && patient.getAnswer().equalsIgnoreCase(answer))
		{
			logger.info("Success");
			model.addAttribute("patientId", patientId);
			return "resetPatientPage";
		}
		else
		{
			logger.info("failed");
			model.addAttribute("msg", "Wrong Question or Answer");
			return "forgetPatientPassword";
		}
		
	}
	@GetMapping("/patienthHome")
	public String gotoHome()
	{
		return "patientHome";
	}
	@PostMapping("/resetPassword/{patientId}")
	public String resetPassword(@RequestParam("password") String rpassword,@PathVariable String patientId,@ModelAttribute("patient") Patient p,Model model)
	{
		Patient patient = patientService.findByPatientId(patientId);
		patient.setPassword(rpassword);
		patientService.savePatient(patient);
		model.addAttribute("msg", "Password Reseted");
		return "resetPatientPage";
		
		
	}
	@GetMapping("/updatePatients")
	public String patients1(Model map) {
		List<Patient> patients = patientDaoImpl.getPatients();
		System.out.println(patients);
		map.addAttribute("patientList", patients);
		return "updaterecords";
	}
	
	@GetMapping("/viewRecommendation")
	public String displayRecommdations(Model map,HttpSession session) {
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient=patientDaoImpl.getPatient(name);
		map.addAttribute(patient);
		return "viewRecommendations";
	}
    
	@GetMapping("/raiseTest")
	public String patientRecord2(@ModelAttribute("patient") Patient patient)
	{
		return "raiseTestRequest";
	}
	
	@PostMapping("/raiseTest")
	public String patientReport3(@RequestParam("testRequest") String test,ModelMap model,@ModelAttribute("patient") Patient patient, HttpSession session) {
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=patientService.findByPatientId(name);
		patient1.setTestRequest(test);
		patient1.setTestResult("Raised");
		patientService.savePatient(patient1);
		model.addAttribute("patient",patient1);
	logger.debug(patient1);
		return "raiseSuccess";
		
	}
	
	@GetMapping("/viewTestresult") //modified
	public String displayTestresults(Model map,HttpSession session) {
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient=patientDaoImpl.getPatient(name);
		map.addAttribute(patient);
		return "viewTestresults";
	}
}
