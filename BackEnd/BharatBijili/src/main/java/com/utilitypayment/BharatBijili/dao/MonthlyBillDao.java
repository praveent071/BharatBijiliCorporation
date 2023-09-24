package com.utilitypayment.BharatBijili.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utilitypayment.BharatBijili.model.Customer;
import com.utilitypayment.BharatBijili.model.MonthlyBill;


@Repository
public class MonthlyBillDao {
	@Autowired
	SessionFactory factory;
	
	public MonthlyBill findById(Long id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(MonthlyBill.class);
		criteria.add(Restrictions.eq("id", id));
		return (MonthlyBill) criteria.uniqueResult();
	}
	
	public void updatePaid(Long id) {
		Session session = factory.openSession();
		MonthlyBill monthlybill = session.get(MonthlyBill.class, id);
		monthlybill.setPaid(true);
		session.saveOrUpdate(monthlybill);
		session.beginTransaction().commit();
	}
	
	public Customer findByCId(Long id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("id", id));
		return (Customer) criteria.uniqueResult();
	}

	public List<MonthlyBill> showbyCustomer(Long customerId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(MonthlyBill.class);
		return criteria.list();
	}
	
	public List<MonthlyBill> findBillByCustomerId(Long customerId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(MonthlyBill.class);
	    criteria.createAlias("customer", "c");
	    criteria.add(Restrictions.eq("c.customerId", customerId));
	    criteria.add(Restrictions.eq("paid",false));
		return criteria.list();
	}

	public List<MonthlyBill> getpaidBills(Long customerId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(MonthlyBill.class);
	    criteria.createAlias("customer", "c");
	    criteria.add(Restrictions.eq("c.customerId", customerId));
	    criteria.add(Restrictions.eq("paid",true));
		return criteria.list();
	}

}
