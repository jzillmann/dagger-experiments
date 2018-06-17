package io.morethan.dagger_experiments.component_inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.morethan.dagger_experiments.component_inheritance.impl.AppComponent;
import io.morethan.dagger_experiments.component_inheritance.impl.DaggerAppComponent;
import io.morethan.dagger_experiments.component_inheritance.impl.ServerComponent;
import io.morethan.dagger_experiments.models.ServerService;

class ComponentInheritanceTest {

    @Test
    void test_fallbackToServerComponent() {
        // Builder methods of ServerComponent switch the builder from AppComponent to ServerComponent
        ServerComponent serverComponent = DaggerAppComponent.builder()
                .serviceName("my Service")
                .port(23)
                .build();

        System.out.println(serverComponent.server());
        assertThat(serverComponent.server().getAddress()).isNull();
        assertThat(serverComponent.server().getPort()).isEqualTo(23);
        assertThat(serverComponent.server().getServices()).containsOnly(new ServerService("my Service"));
    }

    @Test
    void test_notUsingBuilderChaining() {
        // Builder methods of ServerComponent switch the builder from AppComponent to ServerComponent
        AppComponent.Builder builder = DaggerAppComponent.builder();
        builder.port(23);
        builder.serviceName("my Service");
        AppComponent appComponent = builder.build();

        System.out.println(appComponent.app());
        assertThat(appComponent.server().getAddress()).isNull();
        assertThat(appComponent.server().getPort()).isEqualTo(23);
        assertThat(appComponent.server().getServices()).containsOnly(new ServerService("my Service"));
    }

}
