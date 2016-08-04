package helloworld.camel.rs;

import helloworld.camel.camel.EntrypointsService;
import helloworld.camel.services.api.OddChecker;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class HelloEndpoint {
    @Inject
    EntrypointsService entrypointsService;

    @GET
    public String test() {
        return entrypointsService.getProxy(OddChecker.class).checkNumber("5");
        //return "Hello, world!";
    }
}
