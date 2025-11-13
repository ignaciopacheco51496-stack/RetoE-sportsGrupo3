import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
  static String nombrejugador;
  static String apellidojugador;
  static  String nombreequipo;
  static  int sueldo;
  static LocalDate fechaCreacion;
  static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  static boolean a = false;
  static LocalDate fechanacimiento;
  static String nacionalidadjugador;
  static String nicknamejugador;
  static String roljugador;
  static int salario;


  public static void main(String[] args) {
    JOptionPane.showMessageDialog(null, "Vamos a registrar los datos del equipo de E-sports");


    datos_de_equipos();




  }


  public static void datos_de_equipos(){


      nombreequipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo");

      while (a!=true) {
        try {
          LocalDate hoy = LocalDate.now();
          String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de creación del equipo (dd/MM/yyyy)");
          fechaCreacion = LocalDate.parse(fecha, formatter);
            int añoscreados = hoy.getYear() - fechaCreacion.getYear();

          if (fechaCreacion.isAfter(hoy)) {
            JOptionPane.showMessageDialog(null, "La fecha de creacion no puede ser futura.");
            continue;
          }else if (añoscreados > 75) {
              JOptionPane.showMessageDialog(null, "No existen equipos creados antes de 1950.");
              continue;
          }
          break;
        } catch (DateTimeParseException e) {
          JOptionPane.showMessageDialog(null, "Formato incorrecto. Use el formato dd/MM/yyyy.");
        }
      }

      confirmacionequipo();
      jugadores();



  }


  public static void jugadores(){



      nombrejugador= JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador");
      apellidojugador= JOptionPane.showInputDialog(null, "Ingrese el apellido de jugador");

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

      nacionalidadjugador= JOptionPane.showInputDialog(null, "Ingrese el nacionalidad de jugador");
      nicknamejugador= JOptionPane.showInputDialog(null, "Ingrese el nickname");
      boolean rolvalido=false;
      do {
          roljugador = JOptionPane.showInputDialog(null, "Ingrese el rol \n" +
                  "a) Duelista\n" +
                  "b) Controlador\n" +
                  "c) Iniciador\n" +
                  "d) Centinela");
          roljugador = roljugador.toLowerCase();
          switch (roljugador) {
              case "a":
                  JOptionPane.showMessageDialog(null,"El rol selecionado es Duelista");
                  roljugador="Duelista";
                  rolvalido = true;
                  break;
              case "b":
                  JOptionPane.showMessageDialog(null,"El rol selecionado es Controlador");
                  roljugador="Controlador";
                  rolvalido = true;
                  break;
              case "c":
                  JOptionPane.showMessageDialog(null,"El rol selecionado es Iniciador");
                  roljugador="Iniciador";
                  rolvalido = true;
                  break;
              case "d":
                  JOptionPane.showMessageDialog(null,"El rol selecionado es Centinela");
                  roljugador="Centinela";
                  rolvalido = true;
                  break;
              default:
                  JOptionPane.showMessageDialog(null,"No existe esa opcion, seleccione una entre la a) y la d)");

          }
      }while(!rolvalido);
      String salariojugador= JOptionPane.showInputDialog(null, "Ingrese el salario");
      salario= Integer.parseInt(salariojugador);
      if (salario <= 1500) {


        do {
          String salarios= JOptionPane.showInputDialog(null, "Ingrese el sueldo.(Debe de ser mayor a 1500)");
          sueldo = Integer.parseInt(salarios);
        }while(sueldo < 1500);
      }else {
        sueldo=salario;
      }
      salario=sueldo;
      confirmacionjugador();

  }

  public static void confirmacionequipo(){
    int confirmacion = JOptionPane.showConfirmDialog( null,
            "¿Los datos del equipo son correctos?\n" +
                    "Nombre del equipo: " + nombreequipo + "\n" +
                    "Fecha de creacion: " + fechaCreacion ,
            "Confirmacion",
            JOptionPane.YES_NO_OPTION
    );
    if (confirmacion == JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "El equipo se agregado correctamente.");
    }else {
      datos_de_equipos();
    }
  }


  public static void confirmacionjugador(){
    int confirmacion = JOptionPane.showConfirmDialog( null,
            "¿Los datos del jugador son correctos?\n" +
                    "Nombre: " + nombrejugador + "\n" +
                    "Apellido: " + apellidojugador + "\n" +
                    "Fecha de nacimiento: " + fechanacimiento + "\n" +
                    "Nacionalidad: " + nacionalidadjugador + "\n" +
                    "Nickname: "+ nicknamejugador +"\n" +
                    "Rol: " + roljugador + "\n" +
                    "Salario: "+salario,
            "Confirmacion",
            JOptionPane.YES_NO_OPTION
    );
    if (confirmacion == JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null, "El jugador se agregado correctamente.");
    }else {
      jugadores();
    }
  }

