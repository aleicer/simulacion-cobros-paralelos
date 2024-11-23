package domain;

/**
 * La clase Producto representa un producto con un nombre, precio y tiempo de procesamiento.
 */
public class Producto {
    private String nombre;
    private double precio;
    private int tiempoProcesamiento; // en milisegundos

    /**
     * Constructor para crear un nuevo producto.
     *
     * @param nombre el nombre del producto
     * @param precio el precio del producto
     * @param tiempoProcesamiento el tiempo de procesamiento del producto en milisegundos
     */
    public Producto(String nombre, double precio, int tiempoProcesamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return el precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el tiempo de procesamiento del producto.
     *
     * @return el tiempo de procesamiento en milisegundos
     */
    public int getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }
}