package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.bean.Customer;
import com.example.rest.dao.CustomerDaoImpl;
import com.example.rest.service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	// Get all customers
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	// Get customer based on id
	@GetMapping("/customers/{customerId}")
	public List<Customer> getCustomer(@PathVariable int customerId) {
		return customerService.findAll();
	}

	// Add Customer
	@PostMapping("/customers")
	public Customer addEmployee(@RequestBody Customer theCustomer) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theCustomer.setCustomerId(0);

		// insert customer
		customerService.save(theCustomer);

		// Return custmer info in response to request
		return theCustomer;
	}

	// Update customers
	@PutMapping("/customers")
	public Customer updateCustomer(Customer theCustomer) {
		customerService.save(theCustomer);
		return theCustomer;
	}

	// Delete Customer
	@DeleteMapping("/customers/{customerId")
	public String DeleteCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.findById(customerId);
		if (theCustomer == null) {
			throw new RuntimeException("Customer Id not found - " + customerId);
		}
		customerService.deleteById(customerId);

		return "Deleted customer id - " + customerId;
	}

}
