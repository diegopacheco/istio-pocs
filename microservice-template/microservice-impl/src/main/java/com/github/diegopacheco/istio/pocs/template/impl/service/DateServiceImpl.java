package com.github.diegopacheco.istio.pocs.template.impl.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.github.diegopacheco.istio.pocs.template.contract.DateResult;
import com.github.diegopacheco.istio.pocs.template.contract.DateService;

@Service
public class DateServiceImpl implements DateService{
		
	@Override
	public DateResult getCurrentDate() {
		DateResult dr = new DateResult();
		dr.setDate(new Date().toString());
		return dr;
	}
	
}
