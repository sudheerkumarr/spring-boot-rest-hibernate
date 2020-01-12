package com.example.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.rest.bean.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	// Injecting EntityManage using field DI
	@Autowired
	private EntityManager entityManager;

	// Get all customers
	@Override
	public List<Customer> findAll() {
		// Create session
		Session session = entityManager.unwrap(Session.class);
		// Create query
		Query query = session.createQuery("from Customer", Customer.class);
		// Execute
		List customers = query.getResultList();
		// return
		return customers;
	}


	// Method to save or update customer based on id
	@Override
	public Customer save(Customer customer) {
		// Get current Session
		Session session = entityManager.unwrap(Session.class);
		// Save Customer
		session.saveOrUpdate(customer);
		// Return customer
		return customer;
	}
	
	// Method to get customer based on id
	@Override
	public Customer findById(int theId) {
		// Get current session
		Session session = entityManager.unwrap(Session.class);
		// get the customer
		Customer theCustomer = session.get(Customer.class, theId);
		// return the customer
		return theCustomer;
	}

	// delete customer
	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		System.out.println(theId);
		// Delete object with id
		Query query = session.createQuery(
				"delete from Customer where id = :theId");

		query.setParameter("theId", theId);
		
		query.executeUpdate();

	}

}
