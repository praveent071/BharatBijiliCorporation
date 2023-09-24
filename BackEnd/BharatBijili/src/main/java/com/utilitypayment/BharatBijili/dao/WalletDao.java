package com.utilitypayment.BharatBijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.utilitypayment.BharatBijili.model.WalletEntity;

@Repository
public class WalletDao {
	@Autowired
	SessionFactory factory;

	public List<WalletEntity> getAllWallet() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(WalletEntity.class);
		return criteria.list();
	}
	public void updateBalance(String acc, double balance) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(WalletEntity.class);
		criteria.add(Restrictions.eq("walletId", acc));
		WalletEntity wallet = (WalletEntity) criteria.uniqueResult();
		wallet.setBalance(balance);
		session.saveOrUpdate(wallet);
		session.beginTransaction().commit();
	}

}
