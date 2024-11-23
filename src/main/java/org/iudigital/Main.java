package org.iudigital;
import domain.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Lista de nombres y productos para elegir
        List<String> nombresClientes = Arrays.asList("Juan", "Maria", "Carlos", "Ana", "Luis", "Sofia", "Pedro", "Lucia", "Miguel", "Laura", "Diana", "Jorge", "Patricia", "Roberto", "Paula", "Andres", "Camila", "Felipe", "Valeria", "Samuel", "Esteban", "Natalia", "Oscar", "Vanessa", "Julio", "Carmen", "Santiago", "Sara", "David", "Alejandra");
        List<Producto> productosDisponibles = new ArrayList<>();

        // Generar 30 productos diferentes
        for (int i = 1; i <= 30; i++) {
            productosDisponibles.add(new Producto("Producto" + i, random.nextDouble() * 10 + 1, random.nextInt(1000) + 500));
        }
        // Pedir al usuario la cantidad de clientes y cajeras
        int modoEjecucion = 0;
        while (modoEjecucion != 1 && modoEjecucion != 2 && modoEjecucion != 3) {
            System.out.print("Seleccione el modo de ejecución (1: Paralela, 2: Secuencial, 3: Salir): ");
            try {
                modoEjecucion = scanner.nextInt();
                if (modoEjecucion != 1 && modoEjecucion != 2 && modoEjecucion != 3) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }

        if (modoEjecucion == 3) {
            System.out.println("Saliendo de la ejecución.");
            scanner.close();
            return;
        }

        // Pedir al usuario la cantidad de clientes y cajeras
        System.out.print("Ingrese la cantidad de clientes: ");
        int cantidadClientes = scanner.nextInt();

        System.out.print("Ingrese la cantidad de cajeras: ");
        int cantidadCajeras = scanner.nextInt();
        // Crear los clientes con productos aleatorios
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < cantidadClientes; i++) {
            int cantidadProductos = 2 + random.nextInt(4); // Cada cliente tendrá entre 2 y 5 productos
            List<Producto> productosCliente = new ArrayList<>();
            for (int j = 0; j < cantidadProductos; j++) {
                productosCliente.add(productosDisponibles.get(random.nextInt(productosDisponibles.size())));
            }
            String nombreCliente = nombresClientes.get(i % nombresClientes.size()); // Reusar nombres si exceden 30
            clientes.add(new Cliente(nombreCliente, productosCliente));
        }
        System.out.println("Clientes generados.");
        System.out.println(clientes.size());


        if (modoEjecucion == 1) {
            // Crear e iniciar hilos para las cajeras
            List<Thread> hilosCajeras = new ArrayList<>();
            // Esperar a que todos los hilos terminen
            for (int i = 0; i < cantidadCajeras; i++) {
                List<Cliente> clientesCajera = new ArrayList<>();
                for (int j = i; j < clientes.size(); j += cantidadCajeras) {
                    clientesCajera.add(clientes.get(j));
                }
                Thread cajera = new Thread(new Cajera("Cajera " + (i + 1), clientesCajera));
                hilosCajeras.add(cajera);
                cajera.start();
            }
        } else {
            // Crear e iniciar hilos para las cajeras que ejecutan runLineal
            int clientesPorCajera = (int) Math.ceil((double) clientes.size() / cantidadCajeras);
            for (int i = 0; i < cantidadCajeras; i++) {
                List<Cliente> clientesCajera = new ArrayList<>();
                for (int j = i * clientesPorCajera; j < (i + 1) * clientesPorCajera && j < clientes.size(); j++) {
                    clientesCajera.add(clientes.get(j));
                }
                Cajera cajera = new Cajera("Cajera Lineal " + (i + 1), clientesCajera);
                cajera.runLineal();
            }
        }
        scanner.close();
    }
}