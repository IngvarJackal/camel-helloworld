package helloworld.camel.rs;

import com.t2.cn.t2prov.camel.utils.entrypoints.EntryService;
import helloworld.camel.services.api.OddChecker;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
public class HelloEndpoint {
    @Inject
    EntryService entryService;

    @GET
    @Path("/isOdd")
    public String test(@QueryParam("number") String number) {
        return entryService.getProxy(OddChecker.class).checkNumber(number);
    }
}
