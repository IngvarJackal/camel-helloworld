package helloworld.camel.services.api;

import com.t2.cn.t2prov.camel.utils.entrypoints.api.ServiceEntry;
import helloworld.camel.Entrypoints;

public interface OddChecker {
    @ServiceEntry(Entrypoints.ODD_CHECKER)
    String checkNumber(String number);
    @ServiceEntry(Entrypoints.ODD_CHECKER_INTERNAL)
    Boolean checkNumber(Integer number);
}
