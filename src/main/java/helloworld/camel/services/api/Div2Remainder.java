package helloworld.camel.services.api;

import helloworld.camel.camel.Entrypoints;
import helloworld.camel.camel.ServiceEnrtypoint;

public interface Div2Remainder {
    @ServiceEnrtypoint(Entrypoints.DIV_2_REMINDER)
    Integer getDivisionReminder(Integer number);
}
