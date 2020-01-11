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
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Customer> findAll() {
		// Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// Create a query
		Query query = currentSession.createQuery("from Customer", Customer.class);
		// Execute query and get results
		List<Customer> customers = query.getResultList();
		// return result
		return customers;
	}

	@Override
	public Customer findById(int theId) {
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// get the customer
		Customer theCustomer = currentSession.get(Customer.class, theId);
		// return the customer
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// save employee
		// Note: if id=0, performs insert 
		// if id=non-zero perform update
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Delete object with primary key
		Query query = currentSession.createQuery(
				"delete from Customer where id:=theId");
		
		query.setParameter("CustomerId", theId);
		query.executeUpdate();
	}
}
