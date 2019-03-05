package com.github.diegopacheco.istio.microservices.time.driver.v1;

import java.net.HttpURLConnection;
import java.net.URL;

import com.github.diegopacheco.istio.microservices.time.contract.DateResult;
import com.github.diegopacheco.istio.microservices.time.contract.TimeService;
import com.github.diegopacheco.istio.microservices.time.driver.core.HttpUtils;
import com.github.diegopacheco.istio.microservices.time.driver.core.PropsUtils;
import com.google.gson.Gson;

public class TimeServiceDriver {
	
	private static Gson g = new Gson();
	
	public static TimeService build() {
		return new TimeService() {
			@Override
			public DateResult getDate() {
				try {
					String url =  PropsUtils.getServerURI() + "/rest/datetime";
					
					URL obj = new URL(url);
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");

					DateResult dr = g.fromJson(HttpUtils.inputStreamToString(con.getInputStream()),DateResult.class);
					return dr;
					
				}catch(Exception e) {
					throw new RuntimeException("Error Calling microservice. ", e);
				}
			}
		};
	}
	
}
