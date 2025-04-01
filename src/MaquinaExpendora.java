import clases.Golosinas; // estas dos cosas se pueden importar de forma manual, pero es mas rapido boton derecho -> import
import clases.Producto;

import javax.swing.*;

public class MaquinaExpendora implements OperacionesMaquina {
    private final Golosinas[][] productos = new Golosinas[4][4];
    private int[][] stock = new int[4][4];
    private double totalVentas = 0;

    // Metodo constructor = construir la maquina expendedora
    public MaquinaExpendora() {
        inicializarProductos();
        rellenarMaquina(5);
    }

    // Metodos internos que solo seran accesibles cuando se cree la maquina, cuando se llame el metodo constructor
    private void inicializarProductos() {
        // Como los productos van en la clase golosina y se necesita el nombre y precio...
        String[][] nombres = {
                {"KitKat", "Chicles de fresa", "Lacasitos", "Conguitos"},
                {"KinderBueno", "Haribo", "Chettos Pandilla", "Twix"},
                {"Oreo", "M&M", "Lays", "Chicles de menta"},
                {"Chocolate Milka", "Filipinos", "Huesitos", "Doritos"}
        };
        double[][] precios = {
                {1.4, 2, 2.5, 1.5},
                {2.5, 1, 1.4, 2.30},
                {1.6, 2.2, 1, 3.5},
                {3, 1.8, 1.7, 2.9},
        };

        // En este punto tenemos que rellenar el array de productos con nombre y precio
        for (int i = 0; i < stock.length; i++) {
            for (int j = 0; j < stock[i].length; j++) {
                productos [i][j] = new Golosinas(nombres [i][j], precios [i][j]);
            }
        }
    }
    private void rellenarMaquina( int cant){
    for (int i = 0; i < stock.length; i++) {
        for (int j = 0; j < stock[i].length; j++) {
            stock [i][j] = cant;
        }
    }
  }

    // Implementar metodos de la interfaz
    @Override
    public StringBuilder mostrarGolosinas(){
        StringBuilder sb = new StringBuilder("Golosinas disponibles: \n");
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[i].length; j++) {
                sb.append(i).append(j).append(" - ").append(productos[i][j]
                        .mostrarProducto()).append("| Stock: ").append(stock[i][j]).append("\n");
            }
        }
        return sb;
    }
    @Override
    public void pedirGolosinas(){
        String op = JOptionPane.showInputDialog(mostrarGolosinas().toString() + "\n Que quieres coger:");
        try {
            int opcion = Integer.parseInt(op);
            int fila = opcion / 10;
            int columna = opcion % 10;
            if (fila >= 0 && fila < 4 && columna >= 0 && columna < 4) {
                if (stock[fila][columna] > 0) {
                    Golosinas g = productos[fila][columna]; // creo un objeto golosina
                    double precio = g.getPrecio(); // leemos el precio
                    // Pedimos al usuario que nos indique con cuanto nos va a pagar
                    String dineroString = JOptionPane.showInputDialog("Precio del producto: " + precio + "€ Introduce el dinero: ");
                    double dinero = Double.parseDouble(dineroString);
                    // Validamos el dinero ingresado
                    if (dinero >= precio) {
                        double cambio = dinero - precio; // mostramos el cambio
                        stock[fila][columna]--; // restamos el stock
                        totalVentas += precio; // acumulamos la venta
                        JOptionPane.showMessageDialog
                                (null, "Sacando producto: " + g.getNombre() + " tu cambio es: " + String.format("%.2f", cambio) + "€");
                    } else {
                        JOptionPane.showMessageDialog(null, "Dinero insuficiente");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Producto fuera de stock");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Código inválido");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Código inválido");
        }
    }
    @Override
    public void rellenarStock() {
        // El tecnico que rellena el stock tiene una contraseña para poder abrir la maquina
        String pass = JOptionPane.showInputDialog("Introduce la contraseña de Técnico: ");
        if (pass == null) return; // salirse de la ejecución
        if (pass.equals("chuch3s")){
            rellenarMaquina(5);
            JOptionPane.showMessageDialog(null, "Se ha rellenado correctamente el stock");
        }else{
            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta. Acceso denegado");
        }
    }
    @Override
    public void apagarMaquina() {
    JOptionPane.showMessageDialog(null, "Total recaudado: " + String.format("%.2f",totalVentas) + "€");
    } // Muestra el total recaudado
}
