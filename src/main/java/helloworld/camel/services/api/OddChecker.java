package helloworld.camel.services.api;

import helloworld.camel.camel.Entrypoints;
import helloworld.camel.camel.ServiceEnrtypoint;

public interface OddChecker {
    @ServiceEnrtypoint(Entrypoints.ODD_CHECKER)
    String checkNumber(String number);
    @ServiceEnrtypoint(Entrypoints.ODD_CHECKER_INTERNAL)
    Boolean checkNumber(Integer number);
}
