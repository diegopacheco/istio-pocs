package com.github.diegopacheco.istio.microservices.time.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.diegopacheco.istio.microservices.time.service.TimeService;

@Path("/")
public class TimeServiceRestEndpoint extends Application{
	
	@Inject
	private TimeService service;
	
  @GET
  @Path("/health")
  public Response health() {
      return Response.ok().type(MediaType.APPLICATION_JSON).entity("{\"status\": \"200\"}").build();
  }
	
  @GET
  @Path("/datetime")
  public Response datetime() {
      return Response.ok().type(MediaType.APPLICATION_JSON).entity("{\"datetime\":" + service.getDate() +"\"}").build();
  }
	
}
