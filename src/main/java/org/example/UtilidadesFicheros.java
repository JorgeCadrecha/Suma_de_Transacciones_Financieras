package org.example;

/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class UtilidadesFicheros {

    public static long obtenerSumaTransacciones(String nombreArchivo) throws IOException {
        long suma = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                suma += Long.parseLong(linea);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return suma;
    }
}
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UtilidadesFicheros {
    public static long sumarTransacciones(List<String> archivos) {
        long total = 0;
        for (String archivo : archivos) {
            try (Scanner scanner = new Scanner(new File(archivo))) {
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    // procesar cada línea y sumar las transacciones
                    // teniendo en cuenta el tipo de formato de cada línea
                    // y el tipo de dato long
                    // por ejemplo:
                    total += Long.parseLong(linea);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado: " + archivo);
            }
        }
        return total;
    }

    public static void generarArchivoRecibos(String departamento, int cantidadRecibos) {
        Random random = new Random();
        String nombreArchivo = departamento + ".txt";
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            for (int i = 1; i <= cantidadRecibos; i++) {
                long monto = random.nextInt(10000) + 1; // generamos un número aleatorio entre 1 y 10000
                writer.println(monto);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el archivo: " + nombreArchivo);
        }
    }
}