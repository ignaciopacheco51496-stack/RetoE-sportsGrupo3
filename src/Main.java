import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    // Variables globales para datos de entrada
    private static String nombre, apellido, nickname, nacionalidad, rol, nombreequipo; ;
    private static double sueldo;
    private static LocalDate fecha;
    private static LocalDate fechaequipo;
    private static int jugadores;
    private static LocalDate fechaMasPequeña=LocalDate.of(9999,12,31);
    private static StringBuilder todas=new StringBuilder();



    // Leer
    private static Scanner sc;

    public static void main(String[] args) {
        try
        {
            sc = new Scanner(System.in);
            int opcion;
            do
            {
                String entrada = JOptionPane.showInputDialog(null, "menu principal\n"
                                                                                        + "Elije una iopcion\n"
                                                                                        + "1. Inscribir jugadores\n"
                                                                                        + "2. inscribir equipos\n"
                                                                                        + "3. salir");
                opcion = Integer.parseInt(entrada);



                switch (opcion) {
                    case 1 -> {

                        solicitarnombrejugador();
                        solicitarapellido();
                        solicitarnacionalidad();
                        solicitarFechanacimiento();
                        solicitarnickname();
                        solicitarrol();
                        solicitarsueldo();
                        solicitarnombreequipo();
                        System.out.println("Tarea guardada correctamente.");

                    }

                    case 2 ->{

                        solicitarnombreequipo();
                        solicitarfechafundacion();
                        solicitarjugadores();
                        System.out.println("Tarea guardada correctamente.");
                    }


                    case 3 ->
                            System.out.println("Saliendo del programa...");

                    default ->
                            System.out.println("Opción no válida.");

                }
            } while (opcion != 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void solicitarnombrejugador() throws Exception{
        boolean error = true;
        do {
            try
            {

                nombre = JOptionPane.showInputDialog(null, "Inscribir el nombre del jugador: ");
                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(nombre);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                JOptionPane.showMessageDialog(null,"La primera letra mayuscula");
            }
        }
        while(error);
    }

    public static void solicitarapellido() throws Exception{
        boolean error = true;
        do {
            try
            {
              apellido = JOptionPane.showInputDialog(null, "Inscribir apellido del jugador: ");
                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(apellido);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                JOptionPane.showInputDialog("La primera letra mayuscula");
            }
        }
        while(error);
    }

    public static void solicitarnacionalidad() throws Exception{
        boolean error = true;
        do {
            try
            {
                nacionalidad = JOptionPane.showInputDialog(null, "Inscribir el nacionalidad del jugador: ");
                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(nacionalidad);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                JOptionPane.showInputDialog("La primera letra mayuscula");
            }
        }
        while(error);
    }

    public static void solicitarFechanacimiento() throws Exception{
        boolean error = true;
        do {
            try {

                String annoq = JOptionPane.showInputDialog("Introduce el año de nacimiento");

                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(annoq);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;
                int anno  = Integer.parseInt(annoq);

                String mesq = JOptionPane.showInputDialog("Introduce el mes de nacimiento");
                int mes  = Integer.parseInt(mesq);
                String diaq = JOptionPane.showInputDialog("Introduce el dia de nacimiento");
                int dia  =  Integer.parseInt(diaq);
                sc.nextLine();
                fecha = LocalDate.of(anno, mes, dia);
                error = false;

                LocalDate hoy = LocalDate.now();
                LocalDate fechaMayoriaEdad = hoy.minusYears(18);

                if (fecha.isAfter(fechaMayoriaEdad)) {
                    JOptionPane.showMessageDialog(null, "La nacimiento no puede ser anterior.");
                    continue;

                    // Volver al inicio del bucle
                }
            }
            catch (InputMismatchException | DateTimeParseException e)
            {
                System.out.print("Los datos de la fecha no son correctos. ");
            }
        }
        while(error);
    }

    public static void solicitarnickname() throws Exception{
        boolean error = true;
        do {
            try
            {
                nickname = JOptionPane.showInputDialog(null, "Inscribir el nickname: ");
                Pattern pattern = Pattern.compile("^1[a-zA-Z0-9]+$");
                Matcher matcher = pattern.matcher(nickname);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("introduce nick correcto");
            }
        }
        while(error);
    }

    public static void solicitarrol() throws Exception{
        boolean error = true;
        do {
            try
            {
                rol = JOptionPane.showInputDialog(null, "Inscribir rol: ");
                Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
                Matcher matcher = pattern.matcher(rol);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("solo letras");
            }
        }
        while(error);
    }

    public static void solicitarsueldo() throws Exception{
        boolean error = true;
        do {
            try
            {
                String input = JOptionPane.showInputDialog(null,"Inscribir sueldo:");
                Pattern pattern = Pattern.compile("^\\d+\\.?\\d*$");
                Matcher matcher = pattern.matcher(input);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

                sueldo = Double.parseDouble(input);

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("Introduce un numero real");
            }
        }
        while(error);
    }

    public static void solicitarnombreequipo() throws Exception{
        boolean error = true;
        do {
            try
            {
                nombreequipo = JOptionPane.showInputDialog(null,"Inscribir nombre del equipo:");
                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(nombreequipo);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("Primera letra mayuscula");
            }
        }
        while(error);
    }



    public static void solicitarfechafundacion() throws Exception{
        boolean error = true;
        do {
            try {

                String annoq = JOptionPane.showInputDialog("Introduce el año de fundación del equipo");
                int anno  = Integer.parseInt(annoq);
                String mesq = JOptionPane.showInputDialog("Introduce el mes de fundación del equipo");
                int mes  = Integer.parseInt(mesq);
                String diaq = JOptionPane.showInputDialog("Introduce el dia de fundación del equipo");
                int dia  =  Integer.parseInt(diaq);
                sc.nextLine();
                fechaequipo = LocalDate.of(anno, mes, dia);
            }
            catch (InputMismatchException | DateTimeParseException e)
            {
                System.out.print("Los datos de la fecha no son correctos.");
            }
        }
        while(error);
    }


    public static void solicitarjugadores() throws Exception{
        boolean error = true;
        do {
            try
            {
                String input = JOptionPane.showInputDialog(null,"Introduce numero de juegadores");
                Pattern pattern = Pattern.compile("^[2-6]$");
                Matcher matcher = pattern.matcher(input);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

                jugadores = Integer.parseInt(input);

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("Solo cantidad permitida de jugadores");
            }
        }
        while(error);
    }
}
