package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("--- listado de alumnos ---");
        while (true) {
            mostrarOpciones();
            if (!ejecutarOpcion(teclado)) {
                break;
            }
        }
    }

    private static boolean ejecutarOpcion(Scanner teclado) throws IOException {
        int opcionElegida = teclado.nextInt();
        teclado.nextLine(); // Consumir el salto de línea restante

        switch (opcionElegida) {
            case 1:
                writeList(teclado, "listado_alumnos.txt");
                return true;
            case 2:
                readList("listado_alumnos.txt");
                return true;
            case 3:
                System.out.println("Programa finalizado");
                return false;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                return true;
        }
    }

    private static void mostrarOpciones() {
        System.out.println("Indica el número de acción que deseas realizar:");
        System.out.println("\t1. Añadir nombres");
        System.out.println("\t2. Mostrar nombres");
        System.out.println("\t3. Salir");
    }

    private static void writeList(Scanner teclado, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); // Modo de agregar (append)

        System.out.println("Indica los nombres que quieras añadir separados por comas:");

        String nombres = teclado.nextLine(); // Utilizar nextLine para leer toda la línea

        String[] nombresList = nombres.split(",");

        for (String nombre : nombresList) {
            String nombreLimpio = nombre.trim();
            writer.write(nombreLimpio);
            writer.newLine();
        }

        writer.close();
    }

    private static void readList(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
