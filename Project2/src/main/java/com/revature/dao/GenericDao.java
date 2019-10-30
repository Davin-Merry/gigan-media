package com.revature.dao;

import java.util.List;

public interface GenericDao <T>{
		
		List<T> getObjectList();
		
		T getObject(String t);
			
		void insertObject(T t);
		
		void update(T t); 		


}
