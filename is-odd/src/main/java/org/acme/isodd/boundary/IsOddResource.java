package org.acme.isodd.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.acme.isodd.control.Computer;

@Path("/is-odd")
public class IsOddResource {

  @Inject
  Computer computer;

  @GET
  @Path("/{number}")
  public boolean isOdd(@PathParam("number") long number) {
    return computer.isOdd(number);
  }
}
