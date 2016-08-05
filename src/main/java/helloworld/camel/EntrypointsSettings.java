package helloworld.camel;

import com.t2.cn.t2prov.camel.utils.entrypoints.api.EntrySettings;

public class EntrypointsSettings implements EntrySettings {
    @Override
    public String getCamelServicesPackage() {
        return "helloworld.camel.services";
    }
}
