package com.utilitypayment.BharatBijili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.utilitypayment.BharatBijili.model.MonthlyBill;
import com.utilitypayment.BharatBijili.service.MonthlyBillService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("monthlybill")
public class MonthlyBillController {
	@Autowired
	MonthlyBillService monthlybillservice;
	//Getting unpaid bills
	@GetMapping("bills/{customerId}")
		public List<MonthlyBill> getbyCustomer(@PathVariable Long customerId){
			return monthlybillservice.showbyCustomer(customerId);
		}
	//Getting unpaid bills
	@GetMapping("paidbills/{customerId}")
	public List<MonthlyBill> getpaidBills(@PathVariable Long customerId){
		return monthlybillservice.getpaidBills(customerId);
	}

	}

		
	


