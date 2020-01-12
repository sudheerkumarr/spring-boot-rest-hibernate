package com.example.rest.dao;

import java.util.List;

import com.example.rest.bean.Customer;

public interface ICustomerDao {
	public List<Customer> findAll();
	public Customer findById(int theId);
	public Customer save(Customer theCustomer);
	public void deleteById(int theId);
	
}
