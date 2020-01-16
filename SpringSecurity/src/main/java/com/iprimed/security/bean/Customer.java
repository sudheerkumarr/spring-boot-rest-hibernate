package com.iprimed.security.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int custId;
	@Column(name="cust_name")
	private String customerName;
	@Column(name="cust_email")
	private String customerEmail;
	@Column(name="cust_contact_no")
	private long customerContactNo;
	@JsonIgnore
	private String password;
	
	public Customer() {}
	
	// Getters and Setters

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getCustomerContactNo() {
		return customerContactNo;
	}

	public void setCustomerContactNo(long customerContactNo) {
		this.customerContactNo = customerContactNo;
	}
	
}
