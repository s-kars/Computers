package com.skars.computers.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.skars.computers.util.IGenericPersistTest;
import com.skars.computers.util.transactomatic.ITransactomaticUnit;
import com.skars.computers.util.transactomatic.base.BaseTransactomaticTest;

public abstract class GenericPersistTest<T extends Detail> extends BaseTransactomaticTest implements IGenericPersistTest<T> {

	private T detail;
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		detail = constructsDetail();
	}

	@Test
	public void testSave() throws Exception {
		getTransactomaticWork().work(new ITransactomaticUnit() {
			
			@Override
			public void performWork() throws Exception {
				getHibernateUtil().getSession().save(detail);
				assertTrue(detail.getId() > 0);
			}
		});
		
		deleteSavedDetail();
	}
	
	@Test
	public void testGet() throws Exception {
		/* Save. */
		getTransactomaticWork().work(new ITransactomaticUnit() {
			
			@Override
			public void performWork() throws Exception {
				getHibernateUtil().getSession().save(detail);
				assertTrue(detail.getId() > 0);
			}
		});
		
		/* Get. */
		getTransactomaticWork().work(new ITransactomaticUnit() {
			
			@Override
			public void performWork() throws Exception {
				Detail detailFromDB = (Detail) getHibernateUtil().getSession().get(getDetailClass(), detail.getId());
				assertNotNull(detailFromDB);
				assertEquals(detail, detailFromDB);
			}
		});
		
		deleteSavedDetail();
	}
	
	@Test
	public void testDelete() throws Exception {
		/* Save. */
		getTransactomaticWork().work(new ITransactomaticUnit() {
			
			@Override
			public void performWork() throws Exception {
				getHibernateUtil().getSession().save(detail);
				assertTrue(detail.getId() > 0);
			}
		});
		
		/* Delete. */
		getTransactomaticWork().work(new ITransactomaticUnit() {
			
			@Override
			public void performWork() throws Exception {
				getHibernateUtil().getSession().delete(detail);
				Detail detailFromDB = (Detail) getHibernateUtil().getSession().get(getDetailClass(), detail.getId());
				assertNull(detailFromDB);
			}
		});
	}
	
	public void deleteSavedDetail() throws Exception {
		getTransactomaticWork().work(new ITransactomaticUnit() {
			
			@Override
			public void performWork() throws Exception {
				getHibernateUtil().getSession().delete(detail);
			}
		});
	}

	@Override
	public abstract T constructsDetail(); 

	@Override
	public abstract Class<T> getDetailClass();
}
