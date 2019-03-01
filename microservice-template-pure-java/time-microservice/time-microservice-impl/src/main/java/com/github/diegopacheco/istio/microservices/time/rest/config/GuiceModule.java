package com.github.diegopacheco.istio.microservices.time.rest.config;

import com.github.diegopacheco.istio.microservices.time.service.SimpleDateTimeServiceService;
import com.github.diegopacheco.istio.microservices.time.service.DateTimeService;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(DateTimeService.class).to(SimpleDateTimeServiceService.class);
	}
	
}