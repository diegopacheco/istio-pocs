package com.github.diegopacheco.istio.pocs.template.impl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.diegopacheco.istio.pocs.template.contract.DateResult;
import com.github.diegopacheco.istio.pocs.template.contract.DateService;

@RefreshScope
@RestController
public class DateServiceRest {
	
	@Autowired
	DateService ds;
	
  @GetMapping("/datetime")
  public ResponseEntity<DateResult> getDateTime() {
      return ResponseEntity.ok(ds.getCurrentDate());
  }
	
}
