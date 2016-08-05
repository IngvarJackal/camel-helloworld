package helloworld.camel.services.api;

import com.t2.cn.t2prov.camel.utils.entrypoints.api.ServiceEntry;
import helloworld.camel.Entrypoints;

public interface CamelProxiedRoutes {
    @ServiceEntry(value = Entrypoints.STRING_TO_INT, pureCamel = true)
    Integer stringToInt(String string);
    @ServiceEntry(value = Entrypoints.BOOLEAN_TO_STRING, pureCamel = true)
    String booleanToString(Boolean bool);
}
