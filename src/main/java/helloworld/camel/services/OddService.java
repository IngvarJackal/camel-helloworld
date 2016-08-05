package helloworld.camel.services;

import com.t2.cn.t2prov.camel.utils.entrypoints.EntryService;
import helloworld.camel.services.api.CamelProxiedRoutes;
import helloworld.camel.services.api.OddChecker;

import javax.inject.Inject;

public class OddService implements OddChecker {
    @Inject
    EntryService entryService;

    public String checkNumber(String number) {
        Integer parsedNum = entryService.getProxy(CamelProxiedRoutes.class).stringToInt(number);
        Boolean remainder = entryService.getProxy(OddChecker.class).checkNumber(parsedNum);
        return entryService.getProxy(CamelProxiedRoutes.class).booleanToString(remainder);
    }

    public Boolean checkNumber(Integer number) {
        return number % 2 != 0;
    }
}
