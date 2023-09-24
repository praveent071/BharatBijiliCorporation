package com.utilitypayment.BharatBijili.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utilitypayment.BharatBijili.dao.PaymentDao;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentdao;

}
