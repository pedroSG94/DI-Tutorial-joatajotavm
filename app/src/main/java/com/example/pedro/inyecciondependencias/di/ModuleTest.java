package com.example.pedro.inyecciondependencias.di;

import com.example.pedro.inyecciondependencias.dijava.Programador;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**clase encargada de proveer las dependencias a nuestros objetos*/
@Module
public class ModuleTest {


    @Named("jotajotavm")
    @Provides
    public Programador providesProgramador(){
        return new Programador("jotajotavm");
    }

    @Named("pedro")
    @Provides
    public Programador providesProgramadorPedro(){
        return new Programador("pedro");
    }

    @Singleton
    @Named("none")
    @Provides
    public Programador providesProgramadorNone(){
        return new Programador();
    }

    @Provides
    public Empresa providesEmpresa(@Named("jotajotavm") Programador programador){
        return new Empresa(programador);
    }
}
