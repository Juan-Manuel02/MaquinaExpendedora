import clases.Golosinas; // estas dos cosas se pueden importar de forma manual, pero es mas rapido boton derecho -> import
import clases.Producto;

public class MaquinaExpendora implements OperacionesMaquina {
    private final Golosinas [][] productos = new Golosinas [4][4];
    private int [][] stock = new int [4][4];
    private double totalVentas = 0;

    // Metodo constructor = construir la maquina expendedora
    public MaquinaExpendora() {
        inicializarProductos();
        rellenarMaquina(5);
    }

    // Metodos internos que solo seran accesibles cuando se cree la maquina, cuando se llame el metodo constructor
    private void inicializarProductos() {

    }

    private void rellenarMaquina(int cant){

    }

    // Implementar metodos
    @Override
    public void mostrarGolosinas() {
    }
    @Override
    public void pedirGolosinas() {
    }
    @Override
    public void rellenarStock() {
    }
    @Override
    public void apagarMaquina() {
    }






















}
