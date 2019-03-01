package com.github.diegopacheco.istio.microservices.time.rest.config;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.google.inject.Guice;
import com.google.inject.Injector;

@ApplicationPath("/rest/")
public class AppResourceConfig extends ResourceConfig {
  
  @Inject
	public AppResourceConfig(ServiceLocator serviceLocator) {
		packages("com.github.diegopacheco.istio.microservices.time.rest");
		Injector injector = Guice.createInjector(new GuiceModule());
		initGuiceIntoHK2Bridge(serviceLocator, injector);
	}


	private void initGuiceIntoHK2Bridge(ServiceLocator serviceLocator, Injector injector) {
		HK2toGuiceModule hk2Module = new HK2toGuiceModule(injector);
		register(hk2Module);
		
		GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
		GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
		guiceBridge.bridgeGuiceInjector(injector);
	}
  
}