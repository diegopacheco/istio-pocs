package com.github.diegopacheco.istio.pocs.template.impl.service.test;

import org.junit.Assert;
import org.junit.Test;

import com.github.diegopacheco.istio.pocs.template.contract.DateResult;
import com.github.diegopacheco.istio.pocs.template.contract.DateService;
import com.github.diegopacheco.istio.pocs.template.impl.service.DateServiceImpl;

public class DateServiceImplTest {
	
	@Test
	public void testDateOk() {
		DateService ds = new DateServiceImpl();
		DateResult dr = ds.getCurrentDate();
		Assert.assertNotNull(dr);
		Assert.assertNotNull(dr.getDate());
	}
	
}
