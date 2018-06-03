package io.morethan.dagger_experiments.module_composition.impl;

import java.util.Set;

import io.morethan.dagger_experiments.models.Server;
import io.morethan.dagger_experiments.models.ServerService;

public class ServerModuleVariant1 extends AbstractServerModule {

    private final int _port;

    public ServerModuleVariant1(int port) {
        _port = port;
    }

    @Override
    public Server server(Set<ServerService> bindableServices) {
        Server myServer = new Server(_port);
        for (ServerService service : bindableServices) {
            myServer.add(service);
        }
        return myServer;
    }

}
