import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
  static int numerojugadores ;
  static int numeroequipos;
  static  Matcher matt;
  static  int sueldo;
  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  static boolean a = false;

  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Vamos a registrar los datos de los equipos de E-sports");
    while (a != true) {
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
      while (a!=true) {
        try {
          LocalDate hoy = LocalDate.now();
          String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de creación del equipo (dd/MM/yyyy)");
          fechaCreacion = LocalDate.parse(fecha, formatter);

          if (fechaCreacion.isAfter(hoy)) {
            JOptionPane.showMessageDialog(null, "La fecha de creacion no puede ser futura.");
            continue;
          }
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
      LocalDate fechanacimiento;
      while (a != true) {
        String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento (dd/MM/yyyy)");

        try {
          fechanacimiento = LocalDate.parse(fecha.trim(), formatter);

          LocalDate hoy = LocalDate.now();
          int edad = hoy.getYear() - fechanacimiento.getYear();

          if (fechanacimiento.isAfter(hoy)) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser futura.");
            continue;
          } else if (edad < 14) {
            JOptionPane.showMessageDialog(null, "El jugador debe tener al menos 14 años o que los cumpla este mismo año.");
            continue;
          } else if (edad > 60) {
            JOptionPane.showMessageDialog(null, "El jugador no puede tener más de 60 años para jugar.");
            continue;
          }

          break;

        } catch (DateTimeParseException e) {
          JOptionPane.showMessageDialog(null, "Formato incorrecto. Use el formato dd/MM/yyyy.");
        }
      }

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
      JOptionPane.showMessageDialog(null, "El sueldo es de: " + salario);


    }while(i < numerojugadores);
    añadirjugador();
  }
  public static void añadirjugador(){
    int opcion;
    if (numerojugadores<6){
      do {
         opcion= JOptionPane.showConfirmDialog(
                null,
                "¿Quiere añadir algún jugador más?",
                "Añadir jugador",
                JOptionPane.YES_NO_OPTION
        );

        if(opcion == JOptionPane.YES_OPTION){
          numerojugadores++;
          String nombrejugador= JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador");
          String apellidojugador= JOptionPane.showInputDialog(null, "Ingrese el apellido de jugador");
          LocalDate fechanacimiento;
          while (a != true) {
            String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de nacimiento (dd/MM/yyyy)");

            try {
              fechanacimiento = LocalDate.parse(fecha.trim(), formatter);

              LocalDate hoy = LocalDate.now();
              int edad = hoy.getYear() - fechanacimiento.getYear();

              if (fechanacimiento.isAfter(hoy)) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser futura.");
                continue;
              } else if (edad < 14) {
                JOptionPane.showMessageDialog(null, "El jugador debe tener al menos 14 años o que los cumpla este mismo año.");
                continue;
              } else if (edad > 60) {
                JOptionPane.showMessageDialog(null, "El jugador no puede tener más de 60 años para jugar.");
                continue;
              }

              break;

            } catch (DateTimeParseException e) {
              JOptionPane.showMessageDialog(null, "Formato incorrecto. Use el formato dd/MM/yyyy.");
            }
          }

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
          JOptionPane.showMessageDialog(null, "El sueldo es de: " + salario);
        }

      }while (opcion == JOptionPane.NO_OPTION);
    }
    JOptionPane.showMessageDialog(null, "Todos los datos del equipo han sido guardados, en total son "+ numerojugadores +" jugadores en el equipo");
  }

}

