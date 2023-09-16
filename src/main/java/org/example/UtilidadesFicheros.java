package org.example;

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
                long monto = random.nextInt(10000) + 1;
                writer.println(monto);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el archivo: " + nombreArchivo);
        }
    }
}