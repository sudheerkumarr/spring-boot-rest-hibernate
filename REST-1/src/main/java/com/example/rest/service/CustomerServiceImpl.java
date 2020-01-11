package com.example.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.bean.Customer;
import com.example.rest.dao.ICustomerDao;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDao.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDao.deleteById(theId);
	}
}
