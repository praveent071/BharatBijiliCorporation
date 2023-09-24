package com.utilitypayment.BharatBijili.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utilitypayment.BharatBijili.model.PaymentMethod;
import com.utilitypayment.BharatBijili.service.PaymentService;
@RestController
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	PaymentService paymentservice;
	
	private List<PaymentMethod> list = new ArrayList<>(Arrays.asList(PaymentMethod.values()));
	
	public List<PaymentMethod> getAllPaymentMethod(){
		return list;
	}
	
	

}
