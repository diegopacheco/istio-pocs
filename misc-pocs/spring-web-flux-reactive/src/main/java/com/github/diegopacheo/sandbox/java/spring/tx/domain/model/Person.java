package com.github.diegopacheo.sandbox.java.spring.tx.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Person {
	private String id;
	private String name;
}