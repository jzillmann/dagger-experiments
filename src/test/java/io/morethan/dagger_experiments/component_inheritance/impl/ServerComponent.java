package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.morethan.dagger_experiments.models.Server;

@Component(modules = { ServerModule.class })
@Singleton
public interface ServerComponent {

    Server server();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder port(int port);

        ServerComponent build();
    }
}
