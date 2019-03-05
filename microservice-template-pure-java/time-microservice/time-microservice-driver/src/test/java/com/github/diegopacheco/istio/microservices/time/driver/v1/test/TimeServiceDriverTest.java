package com.github.diegopacheco.istio.microservices.time.driver.v1.test;

import org.junit.Assert;
import org.junit.Test;

import com.github.diegopacheco.istio.microservices.time.contract.DateResult;
import com.github.diegopacheco.istio.microservices.time.contract.TimeService;
import com.github.diegopacheco.istio.microservices.time.driver.v1.TimeServiceDriver;

public class TimeServiceDriverTest {
	
	@Test
	public void testGetDateCall(){
		TimeService tsd = TimeServiceDriver.build();
		DateResult dr = tsd.getDate();
		Assert.assertNotNull(dr);
		System.out.println(dr); 
	}
	
}
