package io.morethan.dagger_experiments.component_inheritance.impl;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = { ServerModule.class, ServiceModule.class })
@Singleton
public interface ServiceComponent extends ServerComponent {

    @Component.Builder
    interface Builder extends ServerComponent.Builder {

        @BindsInstance
        Builder serviceName(String serviceName);

        @Override
        ServiceComponent build();
    }
}
