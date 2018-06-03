package io.morethan.dagger_experiments.module_composition.impl;

import java.util.Set;

import io.morethan.dagger_experiments.models.Server;
import io.morethan.dagger_experiments.models.ServerService;

public class ServerModuleVariant2 extends AbstractServerModule {

    private final String _address;
    private final int _port;

    public ServerModuleVariant2(String address, int port) {
        _address = address;
        _port = port;
    }

    @Override
    public Server server(Set<ServerService> bindableServices) {
        Server myServer = new Server(_address, _port);
        for (ServerService service : bindableServices) {
            myServer.add(service);
        }
        return myServer;
    }

}
