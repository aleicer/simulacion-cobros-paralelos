package domain;

import java.util.List;

public class Client {
    private String nombre;
    private List<Product> products;

    public Client(String nombre, List<Product> products) {
        this.nombre = nombre;
        this.products = products;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Product> getProductos() {
        return products;
    }
}