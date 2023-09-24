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
import com.utilitypayment.BharatBijili.service.WalletService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("wallet")
public class WalletController {
	@Autowired
	WalletService walletservice;
	//checking walletcard
	@PostMapping("checkwallet/{id}")
	public Transaction CheckValidCard(@PathVariable Long id, @RequestParam("walletId") String walletId, @RequestParam("walletName") String walletName) {
		return walletservice.CheckValidCard(walletId, walletName, id);	
	}

}
