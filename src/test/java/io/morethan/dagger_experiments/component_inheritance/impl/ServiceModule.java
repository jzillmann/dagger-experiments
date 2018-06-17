package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.morethan.dagger_experiments.models.ServerService;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    @IntoSet
    ServerService serviceX(String serviceName) {
        return new ServerService(serviceName);
    }

}
