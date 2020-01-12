package com.example.rest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name="customer_id")
	private int customerId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="customer_email")
	private String customerEmail;
	@Column(name="customer_mobile")
	private long customerMobile;
	@Column(name="password")
	private String password;
	@Column(name="confirm_password")
	private String confirmPassword;
	
	// Constructors
	// Default constructor
	public Customer() {}

	// Parameterized constructor
	public Customer(
			int customerId,
			String customerName,
			String customerEmail,
			long customerMobile,
			String password,
			String confirmPassword) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	
	// Getters and Setters
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public long getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(long customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
