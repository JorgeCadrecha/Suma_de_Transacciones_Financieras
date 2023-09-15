package org.example;

/*
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProcesadorContabilidad implements Runnable {
    private String nombreArchivo;

    public ProcesadorContabilidad(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void run() {
        try {
            long suma = UtilidadesFicheros.obtenerSumaTransacciones(nombreArchivo);
            escribirArchivoResultado(suma);
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    private void escribirArchivoResultado(long suma) throws IOException {
        String nombreArchivoResultado = nombreArchivo + ".res";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoResultado))) {
            bw.write(String.valueOf(suma));
        }
    }
}
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;

public class ProcesadorContabilidad implements Runnable {
    private String archivo;

    public ProcesadorContabilidad(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void run() {
        try {
            long total = UtilidadesFicheros.sumarTransacciones(Collections.singletonList(archivo));
            String resultadoArchivo = archivo + ".res";
            try (PrintWriter writer = new PrintWriter(resultadoArchivo)) {
                writer.println(total);
            } catch (FileNotFoundException e) {
                System.out.println("Error al guardar el resultado en el archivo: " + resultadoArchivo);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de las transacciones del archivo: " + archivo);
        }
    }

    public static int procesarRecibos(String departamento) {
        String nombreArchivo = departamento + ".txt";
        int total = 0;
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                int monto = Integer.parseInt(linea);
                total += monto;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + nombreArchivo);
        }
        return total;
    }
}