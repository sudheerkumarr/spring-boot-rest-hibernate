package com.iprimed.security.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iprimed.security.dao.ICustomerDao;
import com.iprimed.security.bean.Customer;
import com.iprimed.security.bean.CustomerDto;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);
	@Autowired
	private ICustomerDao customerDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = customerDao.findByCustomerName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getCustomerName(), user.getPassword(), new ArrayList<>());

	}
	
	public Customer save(CustomerDto user) {
		Customer newCustomer= new Customer();
		newCustomer.setCustomerName(user.getCustomerName());
		newCustomer.setPassword(bcryptEncoder.encode(user.getPassword()));
		newCustomer.setCustomerEmail(user.getCustomerEmail());
		newCustomer.setCustomerContactNo(user.getCustomerContactNo());
		return customerDao.save(newCustomer);
	}
}