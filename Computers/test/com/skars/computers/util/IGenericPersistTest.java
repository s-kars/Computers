package com.skars.computers.util;

import com.skars.computers.model.Detail;

public interface IGenericPersistTest<T extends Detail> {

	T constructsDetail();
	
	Class<T> getDetailClass();
}
