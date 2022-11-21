package com.cognizant.ptracker.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ADMIN")
public class Admin 
{
  public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="admin_id")
  private Integer adminId;
  
  @Column(name="password")
  private String password;
   
}
