package com.github.diegopacheco.istio.microservices.time.rest.config;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.github.diegopacheco.istio.microservices.time.service.SimpleDateTimeServiceService;
import com.google.inject.Injector;

public class HK2toGuiceModule extends AbstractBinder {

	private Injector guiceInjector;

	public HK2toGuiceModule(Injector guiceInjector) {
		this.guiceInjector = guiceInjector;
	}

	@Override
	protected void configure() {
		bindFactory(new ServiceFactory<SimpleDateTimeServiceService>(guiceInjector, SimpleDateTimeServiceService.class)).to(SimpleDateTimeServiceService.class);
	}

	private static class ServiceFactory<T> implements Factory<T> {

		private final Injector guiceInjector;

		private final Class<T> serviceClass;

		public ServiceFactory(Injector guiceInjector, Class<T> serviceClass) {
			this.guiceInjector = guiceInjector;
			this.serviceClass = serviceClass;
		}

		@Override
		public T provide() {
			return guiceInjector.getInstance(serviceClass);
		}

		@Override
		public void dispose(T versionResource) {
		}
	}
}