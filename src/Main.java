import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
  static int numerojugadores;
  static int numeroequipos;
  static  Matcher matt;
  static  int sueldo;;
  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Vamos a registrar los datos de los equipos de E-sports");
    String equipos = JOptionPane.showInputDialog(null, "Ingrese cuantos equipos hay.(El numero debe de ser par)");
    numeroequipos = Integer.parseInt(equipos);
    datos_de_equipos();
  }


  public static void datos_de_equipos(){
    int i=0;
    do {
      ++i;
      String nombreequipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo");
      String fecha= JOptionPane.showInputDialog(null, "Ingrese el fecha de creacion del equipo(dd/MM/yyyy)");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate fechaCreacion = LocalDate.parse(fecha, formatter);
      String jugadores= JOptionPane.showInputDialog(null, "Ingrese cuantos jugadores hay en el equipo");
      Pattern pat = Pattern.compile("^[2-6]$");
      Matcher mat = pat.matcher(jugadores);
      if(!mat.matches()){


        do {
          JOptionPane.showMessageDialog((Component)null, "El numero de jugadores es incorrecto, un equipo no puede tener mas de 6 jugadores y como minimo 2 sino no podra jugar la jornada");
          jugadores =JOptionPane.showInputDialog(null, "Ingrese el numero de jugadores del equipo, maximo son seis y minimo 2");
          Pattern patt = Pattern.compile("^[2-6]$");
          matt = patt.matcher(jugadores);
        }while (!matt.matches());


      }
      numerojugadores = Integer.parseInt(jugadores);
      jugadores();


    }while(i < numeroequipos);
  }


  public static void jugadores(){
    int i=0;
    do {
      ++i;
      String nombrejugador= JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador");
      String apellidojugador= JOptionPane.showInputDialog(null, "Ingrese el apellido de jugador");
      String nacionalidadjugador= JOptionPane.showInputDialog(null, "Ingrese el nacionalidad de jugador");
      String nicknamejugador= JOptionPane.showInputDialog(null, "Ingrese el nickname");
      String roljugador= JOptionPane.showInputDialog(null, "Ingrese el rol");
      String salariojugador= JOptionPane.showInputDialog(null, "Ingrese el salario");
      int salario= Integer.parseInt(salariojugador);
      if (salario <= 1184) {


        do {
          String salarios= JOptionPane.showInputDialog(null, "Ingrese el sueldo.(Debe de ser mayor a 1184)");
          sueldo = Integer.parseInt(salarios);
        }while(sueldo < 1184);
      }else {
        sueldo=salario;
      }
      salario=sueldo;


    }while(i < numerojugadores);
  }
}

