package com.example.rest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name="cust_id")
	private int customerId;
	
	@Column(name="cust_name")
	private String customerName;
	
	// Constructors
	public Customer() {
		
	}

	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
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
	
}
