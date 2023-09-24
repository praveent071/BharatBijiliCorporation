package com.utilitypayment.BharatBijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.utilitypayment.BharatBijili.model.CreditCardEntity;
@Repository
public class CreditCardDao {
	@Autowired
	SessionFactory factory;

	public List<CreditCardEntity> getAllCard() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(CreditCardEntity.class);
		return criteria.list();
	}

	

}
