package com.utilitypayment.BharatBijili.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utilitypayment.BharatBijili.dao.CustomerDao;
import com.utilitypayment.BharatBijili.exception.CustomerNotFoundException;
import com.utilitypayment.BharatBijili.model.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerdao;

	public Customer showCustomer(Long customerId) {
		List<Customer> list = customerdao.ShowAllCustomer();
		for (Customer customer : list) {
			if(customer.getCustomerId()==customerId) {
				return customer;
			}
			
		}
		throw new CustomerNotFoundException("Customer not found");
	}
	
}
