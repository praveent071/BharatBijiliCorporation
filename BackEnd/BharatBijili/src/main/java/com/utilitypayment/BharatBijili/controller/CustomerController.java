package com.utilitypayment.BharatBijili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utilitypayment.BharatBijili.model.Customer;
import com.utilitypayment.BharatBijili.service.CustomerService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	CustomerService customerservice;
	//checking customer 
	@GetMapping("login/{customerId}")
	public Customer getCustomer(@PathVariable Long customerId) {
		Customer customer = customerservice.showCustomer(customerId);
		return customer;
	}

}
