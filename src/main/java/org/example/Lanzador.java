package org.example;

/*
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lanzador {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Debe proporcionar al menos un archivo como argumento.");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(args.length);

        for (String archivo : args) {
            Runnable procesador = new ProcesadorContabilidad(archivo);
            executor.execute(procesador);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error al esperar a que terminen los procesos: " + e.getMessage());
        }

        // Calcular la suma global
        calcularSumaGlobal(args);
    }

    private static void calcularSumaGlobal(String[] archivos) {
        long sumaGlobal = 0;

        for (String archivo : archivos) {
            try {
                sumaGlobal += UtilidadesFicheros.obtenerSumaTransacciones(archivo + ".res");
            } catch (IOException e) {
                System.err.println("Error al obtener la suma del archivo " + archivo + ": " + e.getMessage());
            }
        }

        // Guardar la suma global en un archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Resultado_global.txt"))) {
            bw.write(String.valueOf(sumaGlobal));
        } catch (IOException e) {
            System.err.println("Error al guardar el resultado global: " + e.getMessage());
        }
    }
}
*/

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lanzador {
    public static void main(String[] args) {
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