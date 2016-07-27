package com.example.pedro.inyecciondependencias.di;

import com.example.pedro.inyecciondependencias.dijava.Programador;


public class Empresa {

    private Programador programador;

    public Empresa(Programador programador) {
        this.programador = programador;
    }

    @Override
    public String toString() {
        return programador.toString();
    }
}
