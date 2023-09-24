package com.utilitypayment.BharatBijili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utilitypayment.BharatBijili.dao.CreditCardDao;
import com.utilitypayment.BharatBijili.model.Transaction;
import com.utilitypayment.BharatBijili.service.CreditCardService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("creditcard")
public class CreditCardController {
	@Autowired
	CreditCardService creditcardservice;
	
	@Autowired
	CreditCardDao creditCardDao;
	//Checking the credit card
	@PostMapping("checkcredit/{id}")
	public Transaction CheckValidCard(@PathVariable Long id, 
			@RequestParam("acc") String acc, 
			@RequestParam("cvv") long cvv,
			@RequestParam("month") int month,
			@RequestParam("year") int year){
		return creditcardservice.CheckValidCard(acc, cvv, id , month , year);	
	}
}
