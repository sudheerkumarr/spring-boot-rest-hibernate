package com.example.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.bean.Customer;
import com.example.rest.dao.ICustomerDao;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	// Injecting ICustomerDao using Field DI
	@Autowired
	private ICustomerDao customerDao;
	
	// Get all customers
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	// Get customer by using id
	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDao.findById(theId);
	}

	// Save or update customer
	@Override
	@Transactional
	public Customer save(Customer theCustomer) {
		return customerDao.save(theCustomer);
	}

	// Delete customer using id
	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDao.deleteById(theId);
	}
}
