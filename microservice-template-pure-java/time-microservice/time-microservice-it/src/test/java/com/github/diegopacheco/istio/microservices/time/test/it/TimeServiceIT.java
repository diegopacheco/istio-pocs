package com.github.diegopacheco.istio.microservices.time.test.it;


import org.junit.Assert;
import org.junit.Test;

import com.github.diegopacheco.istio.microservices.time.contract.DateResult;
import com.github.diegopacheco.istio.microservices.time.it.IntegrationTestConfig;
import com.google.api.client.http.HttpRequest;

public class TimeServiceIT {
	
	@Test
	public void testGetTime() throws Throwable {
		HttpRequest request = IntegrationTestConfig.buildGetRequest("/rest/datetime");
		String rawResponse = request.execute().parseAsString();
		
		Assert.assertNotNull(rawResponse);
		System.out.println(rawResponse);
	}
	
	@Test
	public void testGetTimeSerialization() throws Throwable {
		HttpRequest request = IntegrationTestConfig.buildGetRequest("/rest/datetime");
		
		String rawResponse = request.execute().parseAsString();
		DateResult result = IntegrationTestConfig.unmarshall(rawResponse, DateResult.class);
		
		Assert.assertNotNull(result);
		System.out.println(result);
	}
	
	
}
