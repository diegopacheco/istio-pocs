package com.github.diegopacheco.istio.microservices.time.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.diegopacheco.istio.microservices.time.contract.DateResult;
import com.github.diegopacheco.istio.microservices.time.contract.TimeService;
import com.github.diegopacheco.istio.microservices.time.service.DateTimeService;

@Path("/")
public class TimeServiceRestEndpoint extends Application implements TimeService {
		
	@Inject
	private DateTimeService service;
	
  @GET
  @Path("/health")
  @Produces(MediaType.APPLICATION_JSON)
  public Response health() {
      return Response.ok().type(MediaType.APPLICATION_JSON).entity("{\"status\": \"200\"}").build();
  }
	
  @GET
  @Path("/datetime")
  @Produces(MediaType.APPLICATION_JSON)
  public DateResult getDate() {
  		DateResult dr = new DateResult();
  		dr.setDate(service.getDate());
      return dr;
  }
	
}
