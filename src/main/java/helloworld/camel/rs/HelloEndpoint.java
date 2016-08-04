package helloworld.camel.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class HelloEndpoint {
    @GET
    public String test() {
        return "Hello, world!";
    }
}
