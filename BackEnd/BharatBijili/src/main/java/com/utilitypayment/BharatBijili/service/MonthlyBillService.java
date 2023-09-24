package com.utilitypayment.BharatBijili.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utilitypayment.BharatBijili.dao.MonthlyBillDao;
import com.utilitypayment.BharatBijili.model.Customer;
import com.utilitypayment.BharatBijili.model.MonthlyBill;

@Service
public class MonthlyBillService {
	@Autowired
	MonthlyBillDao monthlybilldao;

	public List<MonthlyBill> showbyCustomer(Long customerId) {
		return monthlybilldao.findBillByCustomerId(customerId);
	}

	public List<MonthlyBill> getpaidBills(Long customerId) {
		return monthlybilldao.getpaidBills(customerId);
	}

}
