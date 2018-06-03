package io.morethan.dagger_experiments.module_composition.impl;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import io.morethan.dagger_experiments.models.ServerService;

@Module
public class AdditionalServerServiceModule {

    private final Set<ServerService> _services = new HashSet<>();

    public AdditionalServerServiceModule add(ServerService service) {
        _services.add(service);
        return this;
    }

    @Provides
    @Singleton
    @ElementsIntoSet
    Set<ServerService> services() {
        return _services;
    }

}
