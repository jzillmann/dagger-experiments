package io.morethan.dagger_experiments.module_composition;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.morethan.dagger_experiments.models.ServerService;
import io.morethan.dagger_experiments.module_composition.impl.AdditionalServerServiceModule;
import io.morethan.dagger_experiments.module_composition.impl.AppComponent;
import io.morethan.dagger_experiments.module_composition.impl.DaggerAppComponent;
import io.morethan.dagger_experiments.module_composition.impl.ServerModuleVariant1;
import io.morethan.dagger_experiments.module_composition.impl.ServerModuleVariant2;

class ModuleCompositionTest {

    @Test
    void test() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .moduleA(new ServerModuleVariant1(23))
                .build();

        System.out.println(appComponent.app());
        assertThat(appComponent.app().server().getAddress()).isNull();
        assertThat(appComponent.app().server().getPort()).isEqualTo(23);
        assertThat(appComponent.app().server().getServices()).containsOnly(new ServerService("X"), new ServerService("Y"));

        appComponent = DaggerAppComponent.builder()
                .moduleA(new ServerModuleVariant2("localhost", 23))
                .build();
        System.out.println(appComponent.app());
        assertThat(appComponent.app().server().getAddress()).isEqualTo("localhost");
        assertThat(appComponent.app().server().getPort()).isEqualTo(23);
        assertThat(appComponent.app().server().getServices()).containsOnly(new ServerService("X"), new ServerService("Y"));

        appComponent = DaggerAppComponent.builder()
                .moduleA(new ServerModuleVariant2("localhost", 23))
                .additionalServices(new AdditionalServerServiceModule().add(new ServerService("Z")))
                .build();
        System.out.println(appComponent.app());
        assertThat(appComponent.app().server().getAddress()).isEqualTo("localhost");
        assertThat(appComponent.app().server().getPort()).isEqualTo(23);
        assertThat(appComponent.app().server().getServices()).containsOnly(new ServerService("X"), new ServerService("Y"), new ServerService("Z"));
    }

}
