import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int seleccion = -1;
        do{
            try {
                String opcion = JOptionPane.showInputDialog("Gestion de torneo E-sports\n"+
                        "1 Inscribir Equipos\n"+
                        "2 Generar calendarios (cerrar torneo)\n" +
                        "3 Registro de games jugados\n"+
                        "4 Ver resumen total\n" +
                        "5 finish");

                if(opcion==null){
                    seleccion = 5;
                } else {
                    seleccion = Integer.parseInt(opcion);

                }
                switch(seleccion){
                    case 1:
                        inscricionEquipo();
                        break;
                    case 2:
                        calendario();
                        break;
                    case 3:
                        resultados();
                        break;
                    case 4:
                        resumen();
                        break;
                    case 5:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error opcion no existente");

                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error opcion no existente");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error opcion no existente");
            }
        }while (seleccion !=5);

    }
    public static void inscricionEquipo(){
    }
    Pattern patronNombreValido = Pattern.compile("^[a-zA-Z0-9]*$]");
    String nombreEquipo;
    boolean nombreValido = false;
    do {
        nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo: ");
        if (nombreEquipo == null) {
            return;
        }
        Matcher matcher = patronNombreValido.matcher(nombreEquipo);
        if (matcher.matches()) {
            nombreValido = true;
        } else {
            JOptionPane.showMessageDialog(null, "Error el nombre del equipo");
        }
    }while(nombreValido==false);
    int numJugadores = 0;
    while(numJugadores < 2 || numJugadores > 6){
        try {
            String cantNumJugadores = JOptionPane.showInputDialog("Cuantos jugadores tiene tu equipo (min: 2, max: 6):");
            if (cantNumJugadores == null) {
                return;

          } else {
                String[] jugadores = cantNumJugadores.split(",");
                numJugadores = Integer.parseInt(jugadores[0]);


            }
        }


    }
    public static void calendario(){


    }
    public static void resultados(){

    }
    public static void resumen(){

    }

}