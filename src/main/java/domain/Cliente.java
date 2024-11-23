package domain;

import java.util.List;

public class Cliente {
    private String nombre;
    private List<Producto> products;

    public Cliente(String nombre, List<Producto> products) {
        this.nombre = nombre;
        this.products = products;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return products;
    }
}