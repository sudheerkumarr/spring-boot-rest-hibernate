package com.iprimed.security.bean;

public class CustomerDto {
	
	private String customerName;
	private String password;
	private String customerEmail;
	private long customerContactNo;
	
	public CustomerDto() {}

	// Getters and setters
	
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
