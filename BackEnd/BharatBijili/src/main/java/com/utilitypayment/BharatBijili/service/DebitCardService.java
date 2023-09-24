package com.utilitypayment.BharatBijili.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utilitypayment.BharatBijili.dao.DebitCardDao;
import com.utilitypayment.BharatBijili.dao.MonthlyBillDao;
import com.utilitypayment.BharatBijili.dao.TranactionDao;
import com.utilitypayment.BharatBijili.exception.CardExpiredException;
import com.utilitypayment.BharatBijili.exception.InsufficientBalanceException;
import com.utilitypayment.BharatBijili.exception.InvalidCardException;
import com.utilitypayment.BharatBijili.model.Customer;
import com.utilitypayment.BharatBijili.model.DebitCardEntity;
import com.utilitypayment.BharatBijili.model.MonthlyBill;
import com.utilitypayment.BharatBijili.model.PaymentMethod;
import com.utilitypayment.BharatBijili.model.Transaction;

@Service
public class DebitCardService {
	
	@Autowired
	DebitCardDao debitcarddao;
	@Autowired
	TranactionDao tranactiondao;
	@Autowired
	MonthlyBillDao monthlybilldao;
	public Transaction CheckValidCard(String cardNumber, long cvv, Long id, int expirationMonth, int expirationYear) {
		MonthlyBill bill = monthlybilldao.findById(id);
		List<DebitCardEntity> list = debitcarddao.getAllCard();
		for (DebitCardEntity debitCard : list) {
			if(debitCard.getCardNumber().equals(cardNumber) && debitCard.getCvv()==cvv) {
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
		         if(debitCard.getBalance() >  bill.getAmount()) {
					transaction.setAmount(amount);
					transaction.setPaymentDate(LocalDate.now());
					transaction.setPaymentMethod(PaymentMethod.DEBIT_CARD);
					double newBalance = debitCard.getBalance()-bill.getAmount();
					debitcarddao.updateBalance(cardNumber,newBalance);
					monthlybilldao.updatePaid(id);
					transaction.setMonthlyBill(bill);
					Customer c = bill.getCustomer();
					transaction.setCustomer(c);
					tranactiondao.addTransaction(transaction);
					return transaction;
					
					}
		         else {
		        	 throw new InsufficientBalanceException("Insufficient Balance");
		        	 }
			}
		}
		 throw new InvalidCardException("Invalid Card Information");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
