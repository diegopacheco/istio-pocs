package com.github.diegopacheco.istio.microservices.time.driver.core;

public class PropsUtils {
	
	public static String getServerURI() {
		return System.getProperty("TARGET_MICROSERVICE_URI","http://localhost:8080");
	}
	
}
