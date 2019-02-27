package com.github.diegopacheco.istio.microservices.time.rest.config;

import com.github.diegopacheco.istio.microservices.time.service.SimpleTimeService;
import com.github.diegopacheco.istio.microservices.time.service.TimeService;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(TimeService.class).to(SimpleTimeService.class);
	}
	
}