package com.github.diegopacheco.istio.microservices.time.rest.config;

import org.glassfish.jersey.server.ResourceConfig;

public class AppResourceConfig extends ResourceConfig {
  public AppResourceConfig() {
    packages("com.github.diegopacheco.istio.microservices.time.rest");
}
}