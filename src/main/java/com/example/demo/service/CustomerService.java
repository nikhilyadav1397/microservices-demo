package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Customer;

public interface CustomerService {
	public Iterable<Customer> getAllCustomer();
	public Optional<Customer> findCustomerById(String customerId);
	public Optional<Customer> findCustomerByName(String customerName);
	public void deleteCustomerById(String customerId);
	public void addCustomer(Customer customer);
}
