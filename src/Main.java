import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
  static int numerojugadores;
  static int numeroequipos;
  static  Matcher matt;
  static  int sueldo;;
  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Vamos a registrar los datos de los equipos de E-sports");
    while (true) {
      try {
        String equipos = JOptionPane.showInputDialog(null, "Ingrese cuántos equipos hay (el número debe ser par)");
        numeroequipos = Integer.parseInt(equipos);

        if (numeroequipos > 0 && numeroequipos % 2 == 0) {
          break;
        } else {
          JOptionPane.showMessageDialog(null, "Debe ingresar un número PAR y mayor que 0.");
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
      }
    }
    datos_de_equipos();
  }


  public static void datos_de_equipos(){
    int i=0;
    do {
      ++i;
      String nombreequipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo");
      LocalDate fechaCreacion;
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      while (true) {
        try {
          String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de creación del equipo (dd/MM/yyyy)");
          fechaCreacion = LocalDate.parse(fecha, formatter);
          break;
        } catch (DateTimeParseException e) {
          JOptionPane.showMessageDialog(null, "Formato incorrecto. Use el formato dd/MM/yyyy.");
        }
      }
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

