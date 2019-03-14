package com.github.diegopacheo.sandbox.java.spring.tx.dao;

import com.github.diegopacheo.sandbox.java.spring.tx.domain.model.Person;

import reactor.core.publisher.Flux;

public interface PersonDAO {
	
	public Flux<Person> getAllData();
	
	public Person insertData(String key,Person p);
	
}
