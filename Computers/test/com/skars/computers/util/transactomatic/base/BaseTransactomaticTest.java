package com.skars.computers.util.transactomatic.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.skars.computers.util.IConstants;
import com.skars.computers.util.hibernate.HibernateUtil;
import com.skars.computers.util.transactomatic.TransactomaticWork;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { IConstants.SPRING_CONTEXT_LOCATION })
public class BaseTransactomaticTest {

	@Autowired
	private HibernateUtil hibernateUtil;
	
	private TransactomaticWork transactomaticWork;
	
	@Before
	public void setUp() {
		transactomaticWork = new TransactomaticWork(hibernateUtil);
	}

	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public TransactomaticWork getTransactomaticWork() {
		return transactomaticWork;
	}
}
