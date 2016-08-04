package helloworld.camel.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

public class ContextHolder {
    public final CamelContext context;
    public final ProducerTemplate template;

    public ContextHolder(CamelContext context) {
        this.context = context;
        this.template = context.createProducerTemplate();
    }
}
