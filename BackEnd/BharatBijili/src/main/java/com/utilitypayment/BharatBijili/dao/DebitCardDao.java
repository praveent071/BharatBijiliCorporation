package com.utilitypayment.BharatBijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.utilitypayment.BharatBijili.model.DebitCardEntity;

@Repository
public class DebitCardDao {
	@Autowired
	SessionFactory factory;

	public List<DebitCardEntity> getAllCard() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(DebitCardEntity.class);
		return criteria.list();
	}
	
	public void updateBalance(String acc, double balance) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(DebitCardEntity.class);
		criteria.add(Restrictions.eq("cardNumber", acc));
		DebitCardEntity debitcard = (DebitCardEntity) criteria.uniqueResult();
		debitcard.setBalance(balance);
		session.saveOrUpdate(debitcard);
		session.beginTransaction().commit();
	}
}
