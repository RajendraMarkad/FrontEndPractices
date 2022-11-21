package com.cognizant.ptracker.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="PATIENT",schema = "patient_tracker")
public class Patient 
{
  public Integer getP_Id() {
		return p_Id;
	}

	public void setP_Id(Integer p_Id) {
		this.p_Id = p_Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRecommendedSpecialist() {
		return recommendedSpecialist;
	}

	public void setRecommendedSpecialist(String recommendedSpecialist) {
		this.recommendedSpecialist = recommendedSpecialist;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getExecrise() {
		return execrise;
	}

	public void setExecrise(String execrise) {
		this.execrise = execrise;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Integer getTariff() {
		return tariff;
	}

	public void setTariff(Integer tariff) {
		this.tariff = tariff;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getDisDate() {
		return disDate;
	}

	public void setDisDate(String disDate) {
		this.disDate = disDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getRoomCharges() {
		return roomCharges;
	}

	public void setRoomCharges(Integer roomCharges) {
		this.roomCharges = roomCharges;
	}

	public Integer getD_Id() {
		return d_Id;
	}

	public void setD_Id(Integer d_Id) {
		this.d_Id = d_Id;
	}

	public String getSecretQ() {
		return secretQ;
	}

	public void setSecretQ(String secretQ) {
		this.secretQ = secretQ;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getTestRequest() {
		return testRequest;
	}

	public void setTestRequest(String testRequest) {
		this.testRequest = testRequest;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer p_Id;
  
  @Column(name="firstName")
  private String firstName;
  
  @Column(name="lastName")
  private String lastName;
  
  @Column(name="DOB")
  private String dob;
  
  @Column(name="gender")
  private String gender;
  
  //@Size(min = 10, max = 10, message = "ContactNo must be 10 digits")
  @Column(name="contactNo")
  private Long contactNo;
  
  @Column(name="patient_userId")
  private String patientId;
  
  @Column(name="password")
  private String password;
  
  @Column(name="address")
  private String address;
  
  @Column(name="recommendedSpecialist")
  private String recommendedSpecialist;
  
  @Column(name="prescription")
  private String prescription;
  
  @Column(name="status")
  private String status = "pending";
  
  @Column(name="diet")
  private String diet;
  
  @Column(name="execrise")
  private String execrise;
  
  @Column(name="appointmentDate")
  private String appointmentDate;
  
  @Column(name="tariff")
  private Integer tariff=50;
  
  @Column(name="noOfDays")
  private Integer noOfDays;
  
  @Column(name="dischargeDate")
  private String disDate;
  
  @Column(name="roomType")
  private String roomType;
  
  @Column(name="roomCharges")
  private Integer roomCharges;
  
  @Column(name="d_Id")
  private Integer d_Id;
  
  @Column(name="secretQ")
  private String secretQ;
  
  @Column(name="answer")
  private String answer;
  
  @Column(name="testResult")
  private String testResult="";
  
  @Column(name="testRequest")
  private String testRequest;
  
  @Column(name="test")
  private String test;
  
}

