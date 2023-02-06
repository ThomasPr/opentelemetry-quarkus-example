package org.acme.iseven.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.iseven.control.IsOddApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/is-even")
@Produces(MediaType.TEXT_PLAIN)
public class IsEvenResource {

  private static final Logger LOG = Logger.getLogger(IsEvenResource.class);

  @Inject
  @RestClient
  IsOddApi isOddApi;

  @GET
  @Path("/{number}")
  public boolean isEven(@PathParam("number") long number) {
    LOG.info("computing isEven for " + number);
    return !isOddApi.isOdd(number);
  }
}
