package helloworld.camel.rs;

import helloworld.camel.Entrypoints;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class Activator extends Application {
    @Inject
    CamelContext camelContext;

    @PostConstruct
    private void init() {
        try {
            camelContext.addRoutes(new RouteBuilder() {
                public void configure() {
                    from(Entrypoints.BOOLEAN_TO_STRING).process(exchange -> {
                        exchange.getOut().setBody(exchange.getIn().getBody().toString());
                    });
                    from(Entrypoints.STRING_TO_INT).process(exchange -> {
                        exchange.getOut().setBody(Integer.parseInt(exchange.getIn().getBody().toString()));
                    });
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
