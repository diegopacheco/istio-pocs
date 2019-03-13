package com.github.diegopacheo.sandbox.java.spring.tx.dao;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("mysql")
public class SimpleDaoImpl implements SimpleDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public SimpleDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Map<String,Object>> getAllData(){
		return jdbcTemplate.queryForList("SELECT * from PERSON");
	}
	
	@Override
	@Transactional
	public void insertData(int id, String name) {
		jdbcTemplate.execute("insert into PERSON(ID,NAME) VALUES("+id+",'"+name+"')"); 
		System.out.println("Persisted: " + id + " - " + name);
	} 
	
	@Override
	@Transactional
	public void insertDataRollBackME() {
		jdbcTemplate.execute("insert into PERSON(ID,NAME) VALUES("+171+",'Ze"+171+"')");
		throw new RuntimeException("We dont like 171!");
	}
	
}