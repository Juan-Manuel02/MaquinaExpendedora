package clases;

public class Golosinas extends Producto {

    // Constructor
    public Golosinas(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String mostrarProducto() {
        return nombre + " - " + precio + "€";
    }
}
