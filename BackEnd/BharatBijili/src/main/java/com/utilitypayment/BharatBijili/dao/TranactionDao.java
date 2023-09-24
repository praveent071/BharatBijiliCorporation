package com.utilitypayment.BharatBijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.utilitypayment.BharatBijili.model.Transaction;

@Repository
public class TranactionDao {
	@Autowired
	SessionFactory factory;
	
	public void addTransaction( Transaction transaction) {
		Session session = factory.openSession();
		session.save(transaction);
		session.beginTransaction().commit();
		session.close();
	}

	public Transaction gettransaction(Long id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		criteria.add(Restrictions.eq("id", id));
		return (Transaction) criteria.uniqueResult();
	}

}
