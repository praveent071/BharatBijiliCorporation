package com.utilitypayment.BharatBijili.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utilitypayment.BharatBijili.model.Transaction;
import com.utilitypayment.BharatBijili.service.TransactionService;

@RestController
@RequestMapping("transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionservice;
	
	@GetMapping("gettrans/{id}")
	public Transaction gettransaction(@PathVariable Long id){
		return transactionservice.gettransaction(id);
	}
}
