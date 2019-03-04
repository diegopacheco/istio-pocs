package com.github.diegopacheco.istio.microservices.time.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

public class IntegrationTestConfig {

	private static HttpTransport transport = new NetHttpTransport();
	private static JsonFactory jsonFactory = new JacksonFactory();
	private static HttpRequestFactory requestFactory = null;
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String getBaseUrl() {
		String url = System.getProperty("IT_BASEURL", "http://localhost:8080");
		return url;
	}

	public static HttpRequestFactory getRequestFactory() {
		if (requestFactory == null) {
			requestFactory = transport.createRequestFactory((HttpRequest request) -> {
				request.setParser(new JsonObjectParser(jsonFactory));
			});
		}
		return requestFactory;
	}
	
	public static HttpRequest buildGetRequest(String url) {
		try {
			return getRequestFactory().buildGetRequest(new GenericUrl(IntegrationTestConfig.getBaseUrl()+url));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T unmarshall(String json,Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz); 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
