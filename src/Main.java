import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final double SALARIO_MINIMO = 1500.0;

    public static void main(String[] args) {
        registrarEquipo();
        sc.close();
    }

    public static void registrarEquipo() {
        System.out.println("Registro de un solo equipo y un solo jugador");

        System.out.print("Nombre del equipo: ");
        String nombreEquipo = sc.nextLine();

        LocalDate fechaFundacion = null;
        boolean fechaValida = false;
        do {
            try {
                System.out.print("Fecha de fundación (dd/MM/yyyy): ");
                String fechaTexto = sc.nextLine();
                fechaFundacion = LocalDate.parse(fechaTexto, formatoFecha);

                if (fechaFundacion.isBefore(LocalDate.now())) {
                    fechaValida = true;
                } else {
                    System.out.println("La fecha de fundación debe ser menor que hoy.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido, usa dd/MM/yyyy");
            }
        } while (!fechaValida);

        registrarJugador(nombreEquipo, fechaFundacion);
    }

    public static void registrarJugador(String nombreEquipo, LocalDate fechaFundacion) {
        System.out.println("\nRegistro del jugador para el equipo: " + nombreEquipo);
        System.out.println("Fecha de fundación del equipo: " + fechaFundacion.format(formatoFecha));

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Nacionalidad: ");
        String nacionalidad = sc.nextLine();

        LocalDate fechaNacimiento = null;
        boolean fechaValida = false;
        do {
            try {
                System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
                String fechaTexto = sc.nextLine();
                fechaNacimiento = LocalDate.parse(fechaTexto, formatoFecha);

                int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
                if (fechaNacimiento.plusYears(edad).isAfter(LocalDate.now())) {
                    edad--;
                }

                if (edad >= 15 && edad <= 66) {
                    fechaValida = true;
                } else {
                    System.out.println("La edad del jugador debe estar entre 15 y 66 años.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido, usa dd/MM/yyyy");
            }
        } while (!fechaValida);

        System.out.print("Nickname: ");
        String nickname = sc.nextLine();

        String rol = "";
        boolean rolValido = false;
        do {
            System.out.print("Rol (Duelista, Controlador, Iniciador, Centinela): ");
            rol = sc.nextLine().trim();

            String rolMinuscula = rol.toLowerCase();
            if (rolMinuscula.equals("duelista") || rolMinuscula.equals("controlador") ||
                    rolMinuscula.equals("iniciador") || rolMinuscula.equals("centinela")) {
                rolValido = true;
                rol = rol.substring(0,1).toUpperCase() + rol.substring(1).toLowerCase();
            } else {
                System.out.println("Rol inválido. Debe ser: Duelista, Controlador, Iniciador o Centinela.");
            }
        } while (!rolValido);
        double sueldo = 0;
        boolean sueldoValido = false;
        do {
            try {
                System.out.print("Sueldo mayor a 1500: ");
                sueldo = sc.nextDouble();
                sc.nextLine();

                if (sueldo > SALARIO_MINIMO) {
                    sueldoValido = true;
                } else {
                    System.out.println("El sueldo debe ser mayor a " + SALARIO_MINIMO);
                }
            } catch (Exception e) {
                System.out.println("Introduce un número válido mayor a 1500");
                sc.nextLine();
            }
        } while (!sueldoValido);

        System.out.println("\nJugador registrado correctamente:");
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento.format(formatoFecha));
        System.out.println("Nickname: " + nickname);
        System.out.println("Rol: " + rol);
        System.out.println("Sueldo: " + sueldo);
    }
}
