package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.morethan.dagger_experiments.models.App;
import io.morethan.dagger_experiments.models.Server;

@Module
public class AppModule {

    @Provides
    @Singleton
    App app(Server server, double threshold) {
        return new App(server, threshold);
    }
}
