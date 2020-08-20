package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerDao;

@Component
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	@Transactional
	public Iterable<Customer> getAllCustomer() {
		return customerDao.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById(String customerId) {
		return customerDao.findById(customerId);
	}

	@Override
	public Optional<Customer> findCustomerByName(String customerName) {
		return customerDao.findByCustomerName(customerName);
	}
}
