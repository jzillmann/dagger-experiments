package io.morethan.dagger_experiments.component_inheritance.impl;

import java.util.Collections;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import io.morethan.dagger_experiments.models.Server;
import io.morethan.dagger_experiments.models.ServerService;

@Module
public class ServerModule {

    @Provides
    @Singleton
    public Server server(int port, Set<ServerService> bindableServices) {
        Server myServer = new Server(port);
        for (ServerService service : bindableServices) {
            myServer.add(service);
        }
        return myServer;
    }

    @Provides
    @ElementsIntoSet
    @Singleton
    Set<ServerService> serverServices() {
        // This makes declaring of services optional
        return Collections.emptySet();
    }
}
