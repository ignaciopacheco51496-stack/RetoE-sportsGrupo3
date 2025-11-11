import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            imprimir();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    public static void imprimir(){
        JOptionPane.showInputDialog(null,"Ingrese el numero de equipos:");
        solicitarEquipos();
        JOptionPane.showInputDialog(null,"Ingrese el numero jugadores de su equipo" 0+numeroEquipos":");
        solicitarJugadoresEquipos();
        JOptionPane.showInputDialog(null,"Ingrese nombre de su jugadores en orden:"+);


    }
    public static void solicitarEquipos(){
        int cantidadEquipos;
        int numeroEquipos=0;
        Scanner sc = new Scanner(System.in);

    }
    public static void solicitarJugadoresEquipos(){
        int cantidadJugadoresEquipos;
        Scanner sc = new Scanner(System.in);

    }

}