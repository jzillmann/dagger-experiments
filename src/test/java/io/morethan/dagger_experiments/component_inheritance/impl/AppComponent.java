package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.morethan.dagger_experiments.models.App;

@Component(modules = { ServerModule.class, AppModule.class })
@Singleton
public interface AppComponent extends ServerComponent {

    App app();

    @Component.Builder
    interface Builder extends ServerComponent.Builder {

        @BindsInstance
        Builder serviceName(String serviceName);

        @Override
        AppComponent build();
    }
}
