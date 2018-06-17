package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.morethan.dagger_experiments.models.App;
import io.morethan.dagger_experiments.models.Server;
import io.morethan.dagger_experiments.models.ServerService;

@Module
public class AppModule {

    @Provides
    @Singleton
    @IntoSet
    ServerService serviceX(String serviceName) {
        return new ServerService(serviceName);
    }

    @Provides
    @Singleton
    App app(Server server) {
        return new App(server);
    }
}
