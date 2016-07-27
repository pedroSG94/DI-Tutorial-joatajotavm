package com.example.pedro.inyecciondependencias.di;

import com.example.pedro.inyecciondependencias.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


/**interface para hacer de puente entre los módulos y la activity*/
@PerActivity
@Singleton
@Component(
        modules = {
                ModuleTest.class
        }
)
public interface ComponentTest {
    void inject(MainActivity mainActivity);
}
