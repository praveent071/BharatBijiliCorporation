package com.utilitypayment.BharatBijili.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utilitypayment.BharatBijili.dao.MonthlyBillDao;
import com.utilitypayment.BharatBijili.dao.TranactionDao;
import com.utilitypayment.BharatBijili.dao.WalletDao;
import com.utilitypayment.BharatBijili.exception.InsufficientBalanceException;
import com.utilitypayment.BharatBijili.exception.InvalidWalletException;
import com.utilitypayment.BharatBijili.model.Customer;
import com.utilitypayment.BharatBijili.model.MonthlyBill;
import com.utilitypayment.BharatBijili.model.PaymentMethod;
import com.utilitypayment.BharatBijili.model.Transaction;
import com.utilitypayment.BharatBijili.model.WalletEntity;

@Service
public class WalletService {
	@Autowired
	WalletDao walletdao;
	@Autowired
	TranactionDao tranactiondao;
	@Autowired
	MonthlyBillDao monthlybilldao;
	
	public Transaction CheckValidCard(String walletId ,String walletName, Long id) {
		MonthlyBill bill = monthlybilldao.findById(id);
		List<WalletEntity> list = walletdao.getAllWallet();
		for (WalletEntity wallet : list) {
			if(wallet.getWalletId().equals(walletId) && wallet.getWalletName().equalsIgnoreCase(walletName)) {
				if(wallet.getBalance() >  bill.getAmount()) {
					Transaction transaction = new Transaction();
					double amount = bill.getAmount() - bill.getOnlinePayDisAmt();
					LocalDate currentDate = LocalDate.now();
			        if(currentDate.isBefore(bill.getDueDate())) {
			        	 amount = amount - bill.getDueDateDisAmt();
			        }
					transaction.setAmount(amount);
					transaction.setPaymentDate(LocalDate.now());
					transaction.setPaymentMethod(PaymentMethod.WALLET);
					transaction.setMonthlyBill(bill);
					monthlybilldao.updatePaid(id);
					Customer c = bill.getCustomer();
					transaction.setCustomer(c);
					tranactiondao.addTransaction(transaction);
					double newBalance = wallet.getBalance()-bill.getAmount();
					walletdao.updateBalance(walletId,newBalance);
					return transaction;
				}
				else {
					throw new InsufficientBalanceException("Insufficient Balance");
				}	
			}
		}
		throw new InvalidWalletException ("Invalid Wallet Information");	
	}

}
