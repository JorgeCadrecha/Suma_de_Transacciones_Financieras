package org.example.factory;


import org.example.model.ProcesadorContabilidad;

public class ProcesadorContabilidadFactory {
    public static ProcesadorContabilidad crearProcesadorContabilidad(String archivo) {
        return ProcesadorContabilidad.crearProcesadorContabilidad(archivo);
    }
}
