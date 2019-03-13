package com.github.diegopacheo.sandbox.java.spring.tx.dao;

import java.util.List;
import java.util.Map;

public interface SimpleDao {
	
	public List<Map<String,Object>> getAllData();
	
	public void insertData(int id, String name);
	
	public void insertDataRollBackME();
	
}
