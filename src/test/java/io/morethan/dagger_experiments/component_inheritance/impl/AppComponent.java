package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.morethan.dagger_experiments.models.App;

@Component(modules = { ServerModule.class, ServiceModule.class, AppModule.class })
@Singleton
public interface AppComponent extends ServerComponent, ServiceComponent {

    App app();

    @Component.Builder
    interface Builder extends ServerComponent.Builder, ServiceComponent.Builder {

        @BindsInstance
        Builder threshold(double threshold);

        @Override
        AppComponent build();
    }
}
