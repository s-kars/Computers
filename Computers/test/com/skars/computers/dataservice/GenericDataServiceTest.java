package com.skars.computers.dataservice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.skars.computers.model.Detail;
import com.skars.computers.util.IGenericDataServiceTest;
import com.skars.computers.util.transactomatic.ITransactomaticUnit;
import com.skars.computers.util.transactomatic.base.BaseTransactomaticTest;

public abstract class GenericDataServiceTest<T extends Detail> extends BaseTransactomaticTest implements IGenericDataServiceTest<T> {

	private T detail;
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		detail = constructsDetail();
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
				Detail detailFromDB = getDataService().get(detail.getId());
				assertNotNull(detailFromDB);
				assertEquals(detail, detailFromDB);
			}
		});
		
		deleteSavedDetail();
	}

	@Test
	public void testGetAll() throws Exception {
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
				List<T> detailsFromDB = getDataService().getAll();
				assertFalse(detailsFromDB.isEmpty());
				assertTrue(detailsFromDB.size() == 1);
			}
		});
		
		deleteSavedDetail();
	}

	@Test
	public void testDeleteLong() throws Exception{
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
				getDataService().delete(detail.getId());
				Detail detailFromDB = (Detail) getHibernateUtil().getSession().get(getDetailClass(), detail.getId());
				assertNull(detailFromDB);
			}
		});
	}

	@Test
	public void testDeleteT() throws Exception {
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
				getDataService().delete(detail);
				Detail detailFromDB = (Detail) getHibernateUtil().getSession().get(getDetailClass(), detail.getId());
				assertNull(detailFromDB);
			}
		});
	}

	@Test
	public void testSave() throws Exception {
		getTransactomaticWork().work(new ITransactomaticUnit() {
			
			@Override
			public void performWork() throws Exception {
				getDataService().save(detail);
				assertTrue(detail.getId() > 0);
			}
		});
		
		deleteSavedDetail();
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
	public abstract IGenericDataService<T> getDataService();
	
	@Override
	public abstract T constructsDetail();
	
	@Override
	public abstract Class<T> getDetailClass();
}
