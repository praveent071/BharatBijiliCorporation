package com.utilitypayment.BharatBijili.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utilitypayment.BharatBijili.dao.CreditCardDao;
import com.utilitypayment.BharatBijili.dao.MonthlyBillDao;
import com.utilitypayment.BharatBijili.dao.TranactionDao;
import com.utilitypayment.BharatBijili.exception.CardExpiredException;
import com.utilitypayment.BharatBijili.exception.InvalidCardException;
import com.utilitypayment.BharatBijili.model.CreditCardEntity;
import com.utilitypayment.BharatBijili.model.Customer;
import com.utilitypayment.BharatBijili.model.MonthlyBill;
import com.utilitypayment.BharatBijili.model.PaymentMethod;
import com.utilitypayment.BharatBijili.model.Transaction;



@Service
public class CreditCardService {
	@Autowired
	CreditCardDao creditcarddao;
	@Autowired
	TranactionDao tranactiondao;
	@Autowired
	MonthlyBillDao monthlybilldao;
	public List<CreditCardEntity> getallCard() {
		return creditcarddao.getAllCard();
	}
	public Transaction CheckValidCard(String acc, long cvv, Long id, int expirationMonth, int expirationYear) {
		MonthlyBill bill = monthlybilldao.findById(id);
		List<CreditCardEntity> list = creditcarddao.getAllCard();
		for (CreditCardEntity creditCard  : list) {
			if(creditCard.getCardNumber().equals(acc) && creditCard.getCvv()==cvv) {
				 LocalDate currentDate = LocalDate.now();
		         int currentYear = currentDate.getYear();
		         int currentMonth = currentDate.getMonthValue();
		         int lastTwoDigitsOfCurrentYear = currentYear % 100;
		         if (expirationYear % 100 < lastTwoDigitsOfCurrentYear || (expirationYear % 100 == lastTwoDigitsOfCurrentYear && expirationMonth < currentMonth)) {
		        	 throw new CardExpiredException("Card Expired");  
		         } 
		         Transaction transaction = new Transaction();
		         double amount = bill.getAmount() - bill.getOnlinePayDisAmt();
		         
		         if (currentDate.isBefore(bill.getDueDate())) {
		        	 amount = amount - bill.getDueDateDisAmt();
		         }
				 transaction.setAmount(amount);
				 transaction.setPaymentDate(LocalDate.now());
				 transaction.setPaymentMethod(PaymentMethod.CREDIT_CARD);
				 monthlybilldao.updatePaid(id);
				 Customer c = bill.getCustomer();
				 transaction.setCustomer(c);
		         transaction.setMonthlyBill(bill);
				 tranactiondao.addTransaction(transaction);
				 return transaction;
	        }
			 
	    }

		throw new InvalidCardException("Invalid Card Information");
	}
}
