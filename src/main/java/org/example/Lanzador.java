package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lanzador {
    public static void lanzar() {
        List<String> archivos = Arrays.asList(
                "informatica.txt",
                "gerencia.txt",
                "contabilidad.txt",
                "comercio.txt",
                "recursos_humanos.txt"
        );

        UtilidadesFicheros.generarArchivoRecibos("gerencia", 100);
        UtilidadesFicheros.generarArchivoRecibos("informatica", 150);
        UtilidadesFicheros.generarArchivoRecibos("contabilidad", 200);
        UtilidadesFicheros.generarArchivoRecibos("comercio", 75);
        UtilidadesFicheros.generarArchivoRecibos("recursos_humanos", 50);

        // Crea y lanza un hilo para cada archivo
        List<Thread> hilos = new ArrayList<>();
        for (String archivo : archivos) {
            Thread thread = new Thread(new ProcesadorContabilidad(archivo));
            hilos.add(thread);
            thread.start();
        }

        // Espera a que todos los hilos terminen
        for (Thread thread : hilos) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error al esperar a que el hilo termine: " + e.getMessage());
            }
        }

        // Suma todas las sumas de cada archivo de resultados
        long sumaTotal = UtilidadesFicheros.sumarTransacciones(
                archivos.stream().map(a -> a + ".res").collect(Collectors.toList())
        );

        // Guarda el total en Resultado_global.txt
        try (PrintWriter writer = new PrintWriter("Resultado_global.txt")) {
            writer.println(sumaTotal);
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar el resultado global en el archivo Resultado_global.txt");
        }


        int totalGerencia = ProcesadorContabilidad.procesarRecibos("gerencia");
        System.out.println("Total recibos Gerencia: " + totalGerencia);

        int totalInformatica = ProcesadorContabilidad.procesarRecibos("informatica");
        System.out.println("Total recibos Informatica: " + totalInformatica);

        int totalContabilidad = ProcesadorContabilidad.procesarRecibos("contabilidad");
        System.out.println("Total recibos Contabilidad: " + totalContabilidad);

        int totalComercio = ProcesadorContabilidad.procesarRecibos("comercio");
        System.out.println("Total recibos Comercio: " + totalComercio);

        int totalRecursosHumanos = ProcesadorContabilidad.procesarRecibos("recursos_humanos");
        System.out.println("Total recibos Recursos Humanos: " + totalRecursosHumanos);

        System.out.println("TODOS LOS DATOS ESTAN EN SUS ARCHIVOS CORRESPONDIENTES");
    }
}