package com.github.diegopacheco.istio.microservices.time.service;

import javax.inject.Singleton;

import com.github.diegopacheco.istio.microservices.utils.DateUtils;

@Singleton
public class SimpleDateTimeServiceService implements DateTimeService{
	
	@Override
	public String getDate() {
		return DateUtils.getCurrentDate();
	}
	
}
