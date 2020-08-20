package com.example.demo;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerDao;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {
	
	private CustomerDao customerDao;
	public CustomerServiceApplication(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		customerDao.save(new Customer(UUID.randomUUID().toString(), "Spiderman", 200000));
		customerDao.save(new Customer(UUID.randomUUID().toString(), "Superman", 100000));
		customerDao.save(new Customer(UUID.randomUUID().toString(), "Ironman", 70000));
	}

}
