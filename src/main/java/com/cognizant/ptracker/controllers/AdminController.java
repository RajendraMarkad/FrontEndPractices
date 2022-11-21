package com.cognizant.ptracker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.ptracker.exceptions.AdminException;
import com.cognizant.ptracker.model.Admin;
import com.cognizant.ptracker.model.Clerk;
import com.cognizant.ptracker.model.Doctor;
import com.cognizant.ptracker.model.Patient;
import com.cognizant.ptracker.service.AdminService;
import com.cognizant.ptracker.service.DoctorService;
import com.cognizant.ptracker.service.PatientService;

@Controller
public class AdminController {
	
	private static final Logger logger  = Logger.getLogger(AdminController.class);
	
	@Autowired 
	private AdminService adminService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/adminLogin")
	public String AdminLogin()
	{
		return "adminLogin";
	}
	@PostMapping("/adminHome")
	public String loginAuthentication(@RequestParam("adminId") int adminId,
			@RequestParam("password") String password,HttpSession session,ModelMap model) throws AdminException {
	     Admin admin = adminService.findByAdminIdAndPassword(adminId, password);
	     if (!(ObjectUtils.isEmpty(admin))) {
	    	session.setAttribute("adminId", adminId);
	    	logger.debug(session.getAttribute("adminId"));
	    	return "adminHome";
	     }
	     else {
	    	 logger.info("Invalid Username or Password"); 
	    	 throw new AdminException();
	     }
	}
	
	@GetMapping("/patientADetails")
	public String patientADetails(Model map)
	{
		List<Patient> patient = adminService.getPendingPatients();
		map.addAttribute("patientList", patient);
		return "patientADetails";
	}
	@GetMapping("/doctorADetails")
	public String doctorADetails(Model map)
	{
		List<Doctor> doctor = adminService.getPendingDoctors();
		map.addAttribute("doctorList", doctor);
		return "doctorADetails";
	}
	@GetMapping("/clerkADetails")
	public String clerkADetails(Model map)
	{
		List<Clerk> clerk = adminService.getPendingClerk();
		map.addAttribute("clerkList", clerk);
		return "clerkADetails";
	}
	
	@GetMapping("/acceptedPatient/{p_Id}")
	public String acceptedPatient(@PathVariable Integer p_Id,ModelMap map)
	{
		Patient patient = adminService.acceptedPatient(p_Id);
		map.put("patient",patient.getFirstName());
		map.put("msg", ",is Accepted");
		return "patientADetails";
	}
	@GetMapping("/deniedPatient/{p_Id}")
	public String deniedPatient(@PathVariable Integer p_Id,ModelMap map)
	{
		
		Patient patient = adminService.deniedPatient(p_Id);
		map.put("patient",patient.getFirstName());
		map.put("msg", ",is Denied");
		return "patientADetails";
	}
	@GetMapping("/acceptedDoctor/{d_Id}")
	public String acceptedDoctor(@PathVariable Integer d_Id,ModelMap map)
	{
		Doctor doctor = adminService.acceptedDoctor(d_Id);
		map.put("doctor",doctor.getFirstName());
		map.put("msg", ",is Accepted");
		return "doctorADetails";
	}
	@GetMapping("/deniedDoctor/{d_Id}")
	public String deniedDoctor(@PathVariable Integer d_Id,ModelMap map)
	{
		
		Doctor doctor = adminService.deniedDoctor(d_Id);
		map.put("doctor",doctor.getFirstName());
		map.put("msg", ",is Denied");
		return "doctorADetails";
	}
	@GetMapping("/acceptedClerk/{c_Id}")
	public String acceptedClerk(@PathVariable Integer c_Id,ModelMap map)
	{
		Clerk clerk = adminService.acceptedClerk(c_Id);
		map.put("clerk",clerk.getFirstName());
		map.put("msg", ",is Accepted");
		return "clerkADetails";
	}
	@GetMapping("/deniedClerk/{c_Id}")
	public String deniedClerk(@PathVariable Integer c_Id,ModelMap map)
	{
		
		Clerk clerk = adminService.deniedClerk(c_Id);
		map.put("clerk",clerk.getFirstName());
		map.put("msg", ",is Denied");
		return "clerkADetails";
	}
	
	
	@GetMapping("/adminhHome")
	public String gotoHome()
	{
		return "adminHome";
	}
	
	@GetMapping("/editDetails/{pId}")
    public String editDetails(@ModelAttribute("patient") Patient p, @PathVariable Integer pId, ModelMap map) 
    {
        Patient patient = adminService.findByPatientId(pId);
        map.addAttribute("pId", patient.getP_Id());
        String firstName = patient.getFirstName();
        String lastName = patient.getLastName();
        String dob = patient.getDob();
        Long contactNo = patient.getContactNo();
        String patientId = patient.getPatientId();
        String address = patient.getAddress();
        String specialist = patient.getRecommendedSpecialist();
        map.addAttribute("firstName", firstName);
        map.addAttribute("secondName", lastName);
        map.addAttribute("dob", dob);
        map.addAttribute("contactNo", contactNo);
        map.addAttribute("patientId", patientId);
        map.addAttribute("address", address);
        map.addAttribute("specialist", specialist);
        return "editDetails";

 

    }

 

    @PostMapping("/editDetails/{pId}")
    public String editedDetails(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
            @RequestParam("dob") String dob, @RequestParam("contactNo") Long contactNo,
            @RequestParam("patientId") String patientId, @RequestParam("address") String address,
            @PathVariable("pId") Integer pId, ModelMap map) {
        logger.info("Updating Details");
        Patient patient = adminService.findByPatientId(patientId);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDob(dob);
        patient.setContactNo(contactNo);
        patient.setPatientId(patientId);
        patient.setAddress(address);
        logger.debug(patient);
        adminService.save(patient);
        map.addAttribute("patient", patient);
        logger.debug(patient);
        return "updateSucess";
    }
    
    @GetMapping("patient/{pId}")
    public String patientDetails(@PathVariable Integer pId, ModelMap map) {
        Patient patient = adminService.findByPatientId(pId);
        logger.debug(patient);
        map.addAttribute("patient", patient);
        return "patient";
    }
    
    
	@GetMapping("/listofTest")
	public String patients2(Model map) {
		List<Patient> patients = adminService.getPatientStatus();
		System.out.println(patients);
		map.addAttribute("patientList", patients);
		return "listofTest";
	}
	
	@GetMapping("/updateTest/{pId}") //Modified
    public String patientDetails(@ModelAttribute("patient") Patient patient, @PathVariable Integer pId,ModelMap map)
    {
       map.addAttribute("pId",pId);
        return "updateTest";
       
    }
	@PostMapping("/updateTest/{pId}") //Modified
    public String patientDetails1(@RequestParam("testResult") String testResult, @ModelAttribute("patient") Patient patient, @PathVariable Integer pId,ModelMap map)
    {
		Patient patient1=adminService.updateTest(pId);
		patient1.setTestResult(testResult);
		adminService.save(patient1);
       map.addAttribute("pId",pId);
        return "updateSucess";
    }
	
	
	@GetMapping("/patientSDetail")
	public String patientStayDetails(@ModelAttribute("patient") Patient patient) {
		return "patientRecord";
	}
	
	@PostMapping("/patientSDetail")
	public String patientStayDetails1(@RequestParam("patientId") String patientId,@RequestParam("roomType") String roomType,@RequestParam("roomCharges") Integer roomCharges,@RequestParam("disDate") String disDate,@RequestParam("noOfDays") Integer noOfDays,ModelMap model) {
		Patient patient=adminService.findByPatientId(patientId);
		logger.debug(patient);
		patient.setRoomType(roomType);
		patient.setRoomCharges(roomCharges);
	    patient.setDisDate(disDate);
	    patient.setNoOfDays(noOfDays);
			patientService.savePatient(patient);
		model.addAttribute("patient",patient);
		return "updateSucess";
		
	}
	
	@GetMapping("/patientDetails")
    public String patients1(Model map)
    {
        List<Patient> patients= adminService.getPatients();
        System.out.println(patients);
        map.addAttribute("patientList", patients);
        return "patientDetails";
    }
	
	
    
	@GetMapping("/patientIdsub")
	public String patientBill(@ModelAttribute("patient") Patient patient) {
		return "patientIdsub";
	}
	
	@PostMapping("/patientIdsub")
	public String patientBill1(@RequestParam("patientId") String patientId,@ModelAttribute("patient") Patient patient,HttpSession session) {
		session.setAttribute("patientId",patientId);
		return "createBill";
	}
	
	@GetMapping("/createBill")
	public String adminCreateBill(@ModelAttribute("patient") Patient patient) {
		return "createBill";
	}
	
	@GetMapping("/consultation")
	public String consultationFee(@ModelAttribute("patient") Patient patient,HttpSession session,Model map)
	{
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=patientService.getPatient(name);
		Integer id=patient1.getD_Id();
		logger.debug(id);
		Doctor doctor=doctorService.findBydoctorId(id);
		logger.debug(doctor);
		map.addAttribute(doctor);	
		return "consultation";
	}
	
	@GetMapping("/stay")
	public String stayFee(@ModelAttribute("patient") Patient patient,HttpSession session,Model map)
	{
		String name=(String) session.getAttribute("patientId");
		logger.debug(name);
		Patient patient1=patientService.getPatient(name);
		Integer amount=patient1.getTariff()+(patient1.getNoOfDays()*patient1.getRoomCharges());
		map.addAttribute("patient",patient1);
		map.addAttribute("amount",amount);
		return "stay";
	}
	
	@GetMapping("/prescription")
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
	
	@GetMapping("/labCharges")
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
	
	@GetMapping("/nursingCharges")
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
	
	/*@PostMapping("/selectedBill")
	public String billing(@RequestParam("bill") String[] billValue,@ModelAttribute("patient") Patient patient,HttpSession session,Model map) 
	{   
		logger.debug(billValue[0]);
		//if(billValue.length>1)
		//{	
		for(int i=1;i<billValue.length;i++)
		{		
		if(billValue[i-1].equals("consultation") && billValue[i].equals("stay"))
        {
			  logger.debug(billValue[i]);
			  consultationFee(patient,session,map);
			  return stayFee(patient,session,map);
        }
		if(billValue[i].equals("stay"))
    	{
		  logger.debug(billValue[i]);
      	  stayFee(patient,session,map);
    	}
		}
		//}
		return "updateSucess";
	}*/
}
