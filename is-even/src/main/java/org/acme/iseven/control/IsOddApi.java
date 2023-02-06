package org.acme.iseven.control;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/is-odd")
@RegisterRestClient(configKey = "is-odd-api")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public interface IsOddApi {

  @GET
  @Path("/{number}")
  public boolean isOdd(@PathParam("number") long number);

}
