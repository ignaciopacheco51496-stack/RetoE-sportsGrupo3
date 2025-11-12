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
                System.out.println("1. Inscribir jugadores");
                System.out.println("2. inscribir equipos");
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {
                        // Guardar tarea
                        solicitarnombrejugador();
                        solicitarapellido();
                        solicitarnacionalidad();
                        solicitarFechanacimiento();
                        solicitarnickname();
                        solicitarrol();
                        solicitarsueldo();
                        System.out.println("Tarea guardada correctamente.");

                    }

                    case 2 ->{

                        solicitarnombreequipo();
                        solicitarfechafundacion();
                        solicitarjugadores();
                    }


                    case 3 ->
                            System.out.println("Saliendo del programa...");

                    default ->
                            System.out.println("Opción no válida.");
                    // Excepción
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
                System.out.println("nombre del jugador");
                nombre = sc.nextLine();
                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(nombre);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("La primera letra mayuscula");
            }
        }
        while(error);
    }

    public static void solicitarapellido() throws Exception{
        boolean error = true;
        do {
            try
            {
                System.out.println("apellido del jugador");
                apellido = sc.nextLine();
                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(apellido);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("La primera letra mayuscula");
            }
        }
        while(error);
    }

    public static void solicitarnacionalidad() throws Exception{
        boolean error = true;
        do {
            try
            {
                System.out.println("Nacionalidad del jugador");
                nacionalidad = sc.nextLine();
                Pattern pattern = Pattern.compile("^[A-ZÁÉÍÓÚÄËÏÖÜÑ][a-záéíóúäëïöüñ ]+$");
                Matcher matcher = pattern.matcher(nacionalidad);
                if (!matcher.matches())
                    throw new DatoNoValidoException();
                error = false;

            }
            catch (DatoNoValidoException e)
            {
                System.out.print("La primera letra mayuscula");
            }
        }
        while(error);
    }

    public static void solicitarFechanacimiento() throws Exception{
        boolean error = true;
        do {
            try {
                System.out.println("Año de nacimiento");
                int anno  = sc.nextInt();
                System.out.println("Mes de nacimiento");
                int mes  = sc.nextInt();
                System.out.println("Día de nacimiento");
                int dia  = sc.nextInt();
                sc.nextLine();
                fecha = LocalDate.of(anno, mes, dia);
                error = false;

                LocalDate hoy = LocalDate.now();
                LocalDate fechaMayoriaEdad = hoy.minusYears(18);
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
                System.out.println("nick del jugador");
                nickname = sc.nextLine();
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
                System.out.println("rol del jugador");
                rol = sc.nextLine();
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

                System.out.println("sueldo del jugador");
                String input = sc.nextLine();
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
                System.out.println("Nombre del equipo");
                nombreequipo = sc.nextLine();
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
                System.out.println("Año de nacimiento");
                int anno  = sc.nextInt();
                System.out.println("Mes de nacimiento");
                int mes  = sc.nextInt();
                System.out.println("Día de nacimiento");
                int dia  = sc.nextInt();
                sc.nextLine();
                fechaequipo = LocalDate.of(anno, mes, dia);
                error = false;
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
                System.out.println("Nº de jugadores");
                String input = sc.nextLine();
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
