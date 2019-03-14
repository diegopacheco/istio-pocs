package com.github.diegopacheo.sandbox.java.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.github.diegopacheo.sandbox.java.spring.tx.domain.model.Person;

import reactor.core.publisher.Flux;

@Component
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	ReactiveRedisOperations<String, Person> personOps;
	
	@Override
	public Person insertData(String key, Person p) {
		personOps.opsForValue().set(key, p).subscribe(System.out::println);
		return p;
	}
	
	@Override
	public Flux<Person> getAllData() {
		return personOps.keys("*")
        .flatMap(personOps.opsForValue()::get);
	}
	
}
