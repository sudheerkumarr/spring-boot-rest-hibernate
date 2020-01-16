package com.iprimed.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iprimed.security.bean.Customer;


public interface ICustomerDao {
	public Customer findByCustomerName(String custName);
	public List<Customer> findAll();
	public Customer findById(int theId);
	public Customer save(Customer theCustomer);
	public void deleteById(int theId);
	
}
