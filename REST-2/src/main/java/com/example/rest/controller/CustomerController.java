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
import com.example.rest.dao.ICustomerDao;
import com.example.rest.service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	// Get All customers
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}

	// Get customer by using id
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return customerService.findById(customerId);
	}

	// Add customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	// Update customer
	@PutMapping("/customers/{customerId}")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	// Delete customer by using id
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.findById(customerId);
		if (theCustomer == null) {
			throw new RuntimeException("Customer Id not found - " + customerId);
		}
		customerService.deleteById(customerId);

		return "Deleted customer id - " + customerId;
	}
}
