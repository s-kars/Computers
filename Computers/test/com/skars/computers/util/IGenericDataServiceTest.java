package com.skars.computers.util;

import com.skars.computers.dataservice.IGenericDataService;
import com.skars.computers.model.Detail;

public interface IGenericDataServiceTest<T extends Detail> extends IGenericPersistTest<T> {

	IGenericDataService<T> getDataService();
}
