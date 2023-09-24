package com.utilitypayment.BharatBijili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utilitypayment.BharatBijili.model.Transaction;
import com.utilitypayment.BharatBijili.service.DebitCardService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("debitcard")
public class DebitCardController {
	@Autowired
	DebitCardService debitcardservice;
	//checking debitcard
	@PostMapping("checkdebit/{id}")
	public Transaction CheckValidCard(@PathVariable Long id, 
			@RequestParam("acc") String acc, 
			@RequestParam("cvv") long cvv,
			@RequestParam("month") int month,
			@RequestParam("year") int year) {
		return debitcardservice.CheckValidCard(acc, cvv, id , month, year);	
	}


}
