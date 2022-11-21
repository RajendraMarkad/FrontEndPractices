package com.cognizant.ptracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="CLERK")
public class Clerk 
{
  public Integer getC_Id() {
		return c_Id;
	}

	public void setC_Id(Integer c_Id) {
		this.c_Id = c_Id;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getClerkId() {
		return clerkId;
	}

	public void setClerkId(String clerkId) {
		this.clerkId = clerkId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer c_Id;
  
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
  
  @Column(name="qualification")
  private String qualification;

  @Column(name="clerk_userId")
  private String clerkId;
  
  @Column(name="password")
  private String password;
  
  @Column(name="address")
  private String address;
  
  @Column(name="secretQ")
  private String secretQ;
  
  @Column(name="answer")
  private String answer;
  
  @Column(name="status")
  private String status = "pending";
 
  
}


