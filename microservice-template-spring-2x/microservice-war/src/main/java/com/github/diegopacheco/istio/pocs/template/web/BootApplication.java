package com.github.diegopacheco.istio.pocs.template.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.github.diegopacheco.istio.pocs.template"})
@EnableAutoConfiguration
public class BootApplication {
	
  public static void main(String[] args) {
    SpringApplication.run(BootApplication.class, args);
  }
	
}
