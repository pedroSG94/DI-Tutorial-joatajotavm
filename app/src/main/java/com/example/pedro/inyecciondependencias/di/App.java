package com.example.pedro.inyecciondependencias.di;

import android.app.Application;

/**clase para comunicar nuestra activity con dagger2. Debe ser declarada en el manifest*/
public class App extends Application {

    private ComponentTest componentTest;

    @Override
    public void onCreate() {
        super.onCreate();
        componentTest = DaggerComponentTest.builder().moduleTest(new ModuleTest()).build();
    }

    public ComponentTest getComponentTest() {
        return componentTest;
    }
}
