package com.github.diegopacheco.istio.pocs.template.impl.rest;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DateServiceRest {
	
  @GetMapping("/datetime")
  public ResponseEntity<String> hello() {
      return ResponseEntity.ok("OK");
  }
	
}
