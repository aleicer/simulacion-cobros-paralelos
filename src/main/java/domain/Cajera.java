package domain;

import java.util.List;

public class Cajera implements Runnable {
    private String nombre;
    private List<Cliente> clientes;

    public Cajera(String nombre, List<Cliente> clientes) {
        this.nombre = nombre;
        this.clientes = clientes;
    }

    @Override
    public void run() {
        long tiempoInicioGeneral = System.currentTimeMillis();
        for (Cliente cliente : clientes) {
            System.out.println("La cajera " + nombre + " comienza a procesar la compra del cliente " + cliente.getNombre());
            long tiempoInicio = System.currentTimeMillis();

            for (Producto producto : cliente.getProductos()) {
                try {
                    System.out.println("Procesando producto: " + producto.getNombre() +
                            " - Precio: $" + producto.getPrecio() +
                            " - Tiempo de procesamiento: " + producto.getTiempoProcesamiento() + "ms");
                    Thread.sleep(producto.getTiempoProcesamiento());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long tiempoFin = System.currentTimeMillis();
            System.out.println("La cajera " + nombre + " ha terminado de procesar la compra del cliente " +
                    cliente.getNombre() + " en " + (tiempoFin - tiempoInicio) + "ms");
        }
        long tiempoFinGeneral = System.currentTimeMillis();
        System.out.println("Todos los procesos de cobro han terminado.");
        System.out.println("Tiempo total de procesamiento: " + (tiempoFinGeneral - tiempoInicioGeneral) + "ms");
    }

    public void runLineal () {
        long tiempoInicioGeneral = System.currentTimeMillis();
        for (Cliente cliente : clientes) {
            System.out.println("La cajera " + nombre + " comienza a procesar la compra del cliente " + cliente.getNombre());
            long tiempoInicio = System.currentTimeMillis();

            for (Producto producto : cliente.getProductos()) {
                try {
                    System.out.println("Procesando producto: " + producto.getNombre() +
                            " - Precio: $" + producto.getPrecio() +
                            " - Tiempo de procesamiento: " + producto.getTiempoProcesamiento() + "ms");
                    Thread.sleep(producto.getTiempoProcesamiento());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long tiempoFin = System.currentTimeMillis();
            System.out.println("La cajera " + nombre + " ha terminado de procesar la compra del cliente " +
                    cliente.getNombre() + " en " + (tiempoFin - tiempoInicio) + "ms");
        }
        long tiempoFinGeneral = System.currentTimeMillis();
        System.out.println("Todos los procesos de cobro han terminado.");
        System.out.println("Tiempo total de procesamiento: " + (tiempoFinGeneral - tiempoInicioGeneral) + "ms");
    }
}