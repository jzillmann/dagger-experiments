package io.morethan.dagger_experiments.component_inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.morethan.dagger_experiments.component_inheritance.impl.AppComponent;
import io.morethan.dagger_experiments.component_inheritance.impl.DaggerAppComponent;
import io.morethan.dagger_experiments.models.ServerService;

class ComponentInheritanceTest {

    @Test
    void test_Interface_Casting() {
        // Builder methods of ServerComponent switch the builder from AppComponent to ServerComponent,
        // so they have to be called in order of inheritance.
        AppComponent appComponent = (AppComponent) DaggerAppComponent.builder()
                .threshold(23.0)
                .serviceName("my Service")
                .port(23)
                // .threshold(23.0) //does not work!!
                .build();

        System.out.println(appComponent.server());
        assertThat(appComponent.server().getAddress()).isNull();
        assertThat(appComponent.server().getPort()).isEqualTo(23);
        assertThat(appComponent.server().getServices()).containsOnly(new ServerService("my Service"));
    }

    @Test
    void test_notUsingBuilderChaining() {
        // Builder methods of ServerComponent switch the builder from AppComponent to ServerComponent
        AppComponent.Builder builder = DaggerAppComponent.builder();
        builder.port(23);
        builder.serviceName("my Service");
        builder.threshold(23.0);
        AppComponent appComponent = builder.build();

        System.out.println(appComponent.app());
        assertThat(appComponent.server().getAddress()).isNull();
        assertThat(appComponent.server().getPort()).isEqualTo(23);
        assertThat(appComponent.server().getServices()).containsOnly(new ServerService("my Service"));
    }

}
