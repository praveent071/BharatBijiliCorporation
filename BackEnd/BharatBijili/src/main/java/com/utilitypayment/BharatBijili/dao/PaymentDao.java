package com.utilitypayment.BharatBijili.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDao {
	@Autowired
	SessionFactory factory;

}
