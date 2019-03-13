package com.github.diegopacheco.sandbox.java.flux.simplefluxspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SimpleFluxSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFluxSpringApplication.class, args);
	}
	
	@Bean
	CommandLineRunner demo() {
		return args -> {
			 
			 System.out.println("Running flux... ");
			
			 Flux<String> f = Flux.fromArray("1,2,3,4,5,6,7,8,9".split(","));
			 f.map(Integer::parseInt)
			  .filter( i -> i%2==0 )
			  .subscribe( i -> System.out.println(i),null,null);
			 
		};
	}

}
