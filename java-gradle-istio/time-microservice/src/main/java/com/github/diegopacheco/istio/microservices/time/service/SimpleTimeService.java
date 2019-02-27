package com.github.diegopacheco.istio.microservices.time.service;

import com.github.diegopacheco.istio.microservices.utils.DateUtils;

public class SimpleTimeService implements TimeService{
	
	@Override
	public String getDate() {
		return DateUtils.getCurrentDate();
	}
	
}
