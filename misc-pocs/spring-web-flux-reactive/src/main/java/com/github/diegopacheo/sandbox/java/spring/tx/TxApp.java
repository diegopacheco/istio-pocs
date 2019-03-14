package com.github.diegopacheo.sandbox.java.spring.tx;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.diegopacheo.sandbox.java.spring.tx.dao.PersonDAO;
import com.github.diegopacheo.sandbox.java.spring.tx.dao.SimpleDao;
import com.github.diegopacheo.sandbox.java.spring.tx.domain.model.Person;

@SpringBootApplication
@EnableAutoConfiguration
public class TxApp implements CommandLineRunner {
	
	@Autowired
	private SimpleDao db;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Getting data from RDS... ");
		db.getAllData().forEach(System.out::println);
		
		System.out.println("Inserting data into RDS... ");
		Double id = Math.random()*100000;
		db.insertData(id.intValue(), "jon"+id.intValue());
		
		try {
			db.insertDataRollBackME();
		}catch(Exception e) {
			System.out.println("ops: " + e);
		}
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TxApp.class, args);
	}
	
	@Bean
	CommandLineRunner loadData(PersonDAO dao) {
		return args -> {
			  Stream.of("Melina","Dephy","Ike","Garfield")
			  		 .map( (String name) -> new Person(name,name) )
			  		 .map( (Person p) -> dao.insertData(p.getName(), p)) 
			  		 .forEach(System.out::println);
			  
			  dao.getAllData().subscribe(System.out::println,null,null);
			  
		};
	}
	
}

