package com.github.diegopacheco.istio.microservices.time.driver.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpUtils {

	public static String inputStreamToString(InputStream inputStream) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
			}
			in.close();
			return response.toString();
		}catch(Exception e) {
			throw new RuntimeException("Error building response String. ",e);
		}
	}

}
