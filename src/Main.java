import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    MaquinaExpendora maquina = new MaquinaExpendora();
    maquina.pedirGolosinas();
    maquina.pedirGolosinas();
    maquina.mostrarGolosinas();
    maquina.rellenarStock();
    JOptionPane.showMessageDialog(null, maquina.mostrarGolosinas());
    maquina.apagarMaquina();



    }
}