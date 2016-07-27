package com.example.pedro.inyecciondependencias.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**scope para que nuestro componente y todas sus dependencias duren vivas el tiempo de vida de la activity*/
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
