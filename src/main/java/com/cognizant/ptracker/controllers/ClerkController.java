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

import com.cognizant.ptracker.exceptions.ClerkException;
import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.ClerkService;
import com.cognizant.ptracker.service.PatientService;


@Controller
public class ClerkController {

	private static final Logger logger  = Logger.getLogger(ClerkController.class);
	
	@Autowired
	private ClerkService clerkService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/clerkReg")
	public String clerkReg(@ModelAttribute("clerk") Clerk clerk)
	{
		return "clerkReg";
	}
	@PostMapping("/cregSuccess")
	public String savePat(@Valid @ModelAttribute("clerk") Clerk clerk,BindingResult result,ModelMap map)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return "clerkReg";
		}
		clerkService.saveClerk(clerk);
		return "regSucess";
	}
	@GetMapping("/clerkLogin")
	public String loginClerk(@ModelAttribute("clerk") Clerk clerk) {
		return "clerkLogin";

	}
	@PostMapping("/clerkHome")
	public String loginAuthentication(@RequestParam("clerkId") String clerkId,
			@RequestParam("password") String password,HttpSession session,ModelMap model) throws ClerkException {
	     Clerk clerk = clerkService.findByClerkIdAndPassword(clerkId, password);
	     if (!(ObjectUtils.isEmpty(clerk))) {
	    	 if ((clerk.getStatus().equalsIgnoreCase("pending")) || (clerk.getStatus().equalsIgnoreCase("Denied"))) 
	    	 {
	    		 model.addAttribute("msg", "Admin has not accepted your registration");
					return "clerkLogin";
	    	 }
	    	 else
	    	 {
	    		 session.setAttribute("clerkId", clerkId);
	    		 logger.info("Doctor Login Successfull");
	 	    	logger.debug(session.getAttribute("clerkId"));
	 	    	model.put("clerkname", clerk.getFirstName());
	 	    	return "clerkHome";
	    	 }
	    	
	     }
	     else {
	    	 logger.info("Invalid Username or Password - Clerk"); 
	    	 throw new ClerkException();
	     }
		
	}
	
	@GetMapping("/patientDetails1")
    public String patients1(Model map)
    {
        List<Patient> patients= clerkService.getPatients();
        System.out.println(patients);
        map.addAttribute("patientList", patients);
        return "patientDetails";
    }
	
	@GetMapping("/editDetails1/{pId}")
    public String editDetails(@ModelAttribute("patient") Patient p,@PathVariable Integer pId,ModelMap map)
    {
       
        Patient patient = clerkService.findByPatientId(pId);
        map.addAttribute("pId", patient.getP_Id());
        String firstName = patient.getFirstName();
        String lastName = patient.getLastName();
        String dob = patient.getDob();
        String gender = patient.getGender();
        Long contactNo = patient.getContactNo();
        String patientId = patient.getPatientId();
        String address = patient.getAddress();
        String specialist = patient.getRecommendedSpecialist();
        map.addAttribute("firstName", firstName);
        map.addAttribute("secondName", lastName);
        map.addAttribute("dob", dob);
        map.addAttribute("gender", gender);
        map.addAttribute("contactNo", contactNo);
        map.addAttribute("patientId", patientId);
        map.addAttribute("address", address);
        map.addAttribute("specialist", specialist);
        return "editDetails";
       
    }
    @PostMapping("updateSucess1/{pId}")
    public String updateEditedPatients(@PathVariable Integer pId,ModelMap map)
    {
        Patient patient = clerkService.findByPatientId(pId);
        logger.debug(patient);
        clerkService.save(patient);
        return "updateSucess";
    }
   
    @GetMapping("patient1/{pId}")
    public String patientDetails(@PathVariable Integer pId,ModelMap map)
    {
        Patient patient =clerkService.findByPatientId(pId);
        logger.debug(patient);
        map.addAttribute("firstName", patient.getFirstName());
        map.addAttribute("lastName", patient.getLastName());
        map.addAttribute("dob", patient.getDob());
        map.addAttribute("contact", patient.getContactNo());
        map.addAttribute("gender", patient.getGender());
        map.addAttribute("patientId", patient.getPatientId());
        map.addAttribute("address", patient.getAddress());
        map.addAttribute("prescription", patient.getPrescription());
        return "updateSucess";
       
    }
	
    @GetMapping("/patientIdsub1")
	public String patientBill(@ModelAttribute("patient") Patient patient) {
		return "patientIdsub1";
	}
	
	@PostMapping("/patientIdsub1")
	public String patientBill1(@RequestParam("patientId") String patientId,@ModelAttribute("patient") Patient patient,HttpSession session) {
		session.setAttribute("patientId",patientId);
		return "createBill2";
	}
	
	@GetMapping("/createBill1")
	public String adminCreateBill(@ModelAttribute("patient") Patient patient) {
		return "createBill2";
	}
	
	@GetMapping("/consultation1")
	public String consultationFee(@ModelAttribute("patient") Patient patient,HttpSession session,Model map)
	{
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=clerkService.getPatient(name);
		Integer id=patient1.getD_Id();
		logger.debug(id);
		Doctor doctor=clerkService.findBydoctorId(id);
		logger.debug(doctor);
		map.addAttribute(doctor);		
		return "consultation";
	}
	
	@GetMapping("/stay1")
	public String stayFee(@ModelAttribute("patient") Patient patient,HttpSession session,Model map)
	{
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=clerkService.getPatient(name);
		Integer amount=patient1.getTariff()+(patient1.getNoOfDays()*patient1.getRoomCharges());
		map.addAttribute("patient",patient1);
		map.addAttribute("amount",amount);
		return "stay";
	}
	
	@GetMapping("/prescription1")
	public String prescriptionDetails(@ModelAttribute("patient") Patient patient,HttpSession session,Model map)
	{
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=patientService.getPatient(name);
		//Integer amount=patient1.getTariff()+(patient1.getNoOfDays()*patient1.getRoomCharges())+200;
		map.addAttribute("patient",patient1);
		//map.addAttribute("amount",amount);
		return "prescription";
	}
	
	@GetMapping("/labCharges1")
	public String labChargesDetails(@ModelAttribute("patient") Patient patient,HttpSession session,Model map)
	{
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=patientService.getPatient(name);
		Integer amount=0;
		if(patient1.getTestRequest().equals("Endoscope"))
			amount=1000;
		else if(patient1.getTestRequest().equals("Blood Test"))
			amount=500;
		else if(patient1.getTestRequest().equals("ECG"))
			amount=700;
		else if(patient1.getTestRequest().equals("Sugar Test"))
			amount=200;
		amount+=patient1.getTariff();
		map.addAttribute("patient",patient1);
		map.addAttribute("amount",amount);
		return "labCharges";
	}
	
	@GetMapping("/nursingCharges1")
	public String nursingFee(@ModelAttribute("patient") Patient patient,HttpSession session,Model map)
	{
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=patientService.getPatient(name);
		Integer amount=patient1.getTariff()+(patient1.getNoOfDays()*patient1.getRoomCharges())+200;
		map.addAttribute("patient",patient1);
		map.addAttribute("amount",amount);
		return "nursingFees";
	}
}
