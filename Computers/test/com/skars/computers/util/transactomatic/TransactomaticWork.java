package com.skars.computers.util.transactomatic;

import com.skars.computers.util.hibernate.HibernateUtil;

public class TransactomaticWork {

	private HibernateUtil hibernateUtil;
	
	public TransactomaticWork(HibernateUtil hibernateUtil) {
		setHibernateUtil(hibernateUtil);
	}

	public void work(ITransactomaticUnit transactomaticUnit) throws Exception {
		hibernateUtil.beginTransaction();
		transactomaticUnit.performWork();
		hibernateUtil.commitTransaction();
	}
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
}
