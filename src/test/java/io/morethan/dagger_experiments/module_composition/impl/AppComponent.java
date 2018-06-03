package io.morethan.dagger_experiments.module_composition.impl;

import javax.inject.Singleton;

import dagger.Component;
import io.morethan.dagger_experiments.models.App;

@Component(modules = { AppModule.class, AbstractServerModule.class, AdditionalServerServiceModule.class })
@Singleton
public interface AppComponent {

    App app();

    @Component.Builder
    interface Builder {

        Builder moduleA(AbstractServerModule secondModule);

        Builder additionalServices(AdditionalServerServiceModule secondModule);

        AppComponent build();
    }
}
