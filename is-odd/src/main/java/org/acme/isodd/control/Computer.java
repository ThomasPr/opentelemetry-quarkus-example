package org.acme.isodd.control;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;

@ApplicationScoped
public class Computer {

  private static final Logger LOG = Logger.getLogger(Computer.class);

  @WithSpan
  public boolean isOdd(@SpanAttribute long isOddNumber) {
    boolean isOdd = false;

    // by intention, the algorithm is cpu-intensive to create some delay by using larger numbers
    for (long i = 0; i < Math.abs(isOddNumber); i++) {
      isOdd = !isOdd;
    }

    LOG.info(isOddNumber + (isOdd ? " is odd" : " is not odd"));
    return isOdd;
  }
}
