package io.morethan.dagger_experiments.module_composition.impl;

import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.morethan.dagger_experiments.models.Server;
import io.morethan.dagger_experiments.models.ServerService;

@Module
public class AbstractServerModule {

    @Provides
    @Singleton
    Server server(Set<ServerService> bindableServices) {
        throw new UnsupportedOperationException();
    }
}
