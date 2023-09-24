package com.utilitypayment.BharatBijili.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utilitypayment.BharatBijili.dao.TranactionDao;
import com.utilitypayment.BharatBijili.model.Transaction;

@Service
public class TransactionService {
	@Autowired
	TranactionDao transactiondao;

	public Transaction gettransaction(Long id) {
		return transactiondao.gettransaction(id);
	}
}
