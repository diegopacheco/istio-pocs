package com.github.diegopacheo.sandbox.java.spring.tx.conf;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class DSConfiguration {

	@Bean
  public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(Environment e) {
		
  	Properties props = new Properties();
  	props.setProperty("spring.datasource.username", e.getProperty("tx.user"));
  	props.setProperty("spring.datasource.password",e.getProperty("tx.pass"));
  	props.setProperty("spring.datasource.databaseName", e.getProperty("tx.db"));
  	props.setProperty("spring.datasource.readReplicaSupport", "true");
  	props.setProperty("spring.datasource.url", e.getProperty("tx.url"));
  	
  	PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
  	conf.setProperties(props);
    return conf;
  }
	
}