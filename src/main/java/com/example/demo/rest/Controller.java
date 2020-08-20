package com.example.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class Controller {
	private CustomerService customerService;

	public Controller(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	public ResponseEntity<Iterable<Customer>> getAllCustomer() {
		return new ResponseEntity<Iterable<Customer>>(customerService.getAllCustomer(), HttpStatus.OK);
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable("customerId") String customerId) {
//		return new ResponseEntity<Optional<Customer>>(customerService.findCustomerById(customerId), HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.findCustomerById(customerId));
	}

	@GetMapping("/customers/name/{customerName}")
	public ResponseEntity<Optional<Customer>> findCustomerByName(@PathVariable("customerName") String customerName) {
		return new ResponseEntity<Optional<Customer>>(customerService.findCustomerByName(customerName),
				HttpStatus.FOUND);
	}

	@DeleteMapping("/customers/delete/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") String customerId) {
		if (customerService.findCustomerById(customerId) != null) {
			customerService.deleteCustomerById(customerId);
			return new ResponseEntity<String>("Deleted Customer", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Customer Not Found", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/customers/")
	public ResponseEntity<Optional<Customer>> createCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		customer.getCustomerName();
		return new ResponseEntity<Optional<Customer>>(customerService.findCustomerByName(customer.getCustomerName()),
				HttpStatus.OK);
	}
}
