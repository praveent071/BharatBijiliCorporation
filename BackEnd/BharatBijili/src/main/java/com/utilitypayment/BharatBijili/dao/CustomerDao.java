package com.utilitypayment.BharatBijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utilitypayment.BharatBijili.model.Customer;


@Repository
public class CustomerDao {
	@Autowired
	SessionFactory factory;

	public List<Customer> ShowAllCustomer() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}
}
