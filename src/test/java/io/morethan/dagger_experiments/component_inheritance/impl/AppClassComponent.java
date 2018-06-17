package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import io.morethan.dagger_experiments.models.App;

@Component(modules = { ServerModule.class, ServiceModule.class, AppModule.class })
@Singleton
public interface AppClassComponent extends ServerComponent, ServiceComponent {

    App app();

    @Component.Builder
    abstract class Builder implements ServerComponent.Builder, ServiceComponent.Builder {

        @BindsInstance
        public abstract Builder threshold(double threshold);

        @Override
        public abstract AppClassComponent build();
    }
}
