import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static final double SALARIO_MINIMO = 1500.0;
    public static void main(String[] args) {
        inscribirEquipos();
        sc.close();
    }


public static void inscribirEquipos() {
    int equipos = 0;
    boolean valido = false;
    do {
        try {
            System.out.println("Cuantos equipos hay (Debe de ser par) ");
            equipos = sc.nextInt();


            if (equipos % 2 == 0 && equipos > 0) {
                valido = true;
            } else {
                System.out.println("Escribe un numero par");
            }
        } catch (Exception e) {
            System.out.println("Escribe un numero par");
        }
    } while (!valido);
    System.out.println("Inscribir equipos");
    for (int indiceEquipo = 1; indiceEquipo <= equipos; indiceEquipo++) {
        System.out.println("Nombre del equipo " + indiceEquipo + ":");
        sc.nextLine();
        String nombreEquipo = sc.nextLine();

        LocalDate fechaFundacion = null;
        boolean fechaValida = false;
        do {
            try {
                System.out.print("Fecha de fundación (dd/MM/yyyy): ");
                String fechaTexto = sc.nextLine();
                fechaFundacion = LocalDate.parse(fechaTexto, formatoFecha);

                // Validar que la fecha sea menor que hoy
                if (fechaFundacion.isBefore(LocalDate.now())) {
                    fechaValida = true;
                } else {
                    System.out.println("La fecha de fundación debe ser menor que hoy.");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido, usa dd/MM/yyyy");
            }
        } while (!fechaValida);

        int numJugadores = 0;
        boolean jugadoresValidos = false;
        do {
            System.out.print("Cuantos jugadores tiene " + nombreEquipo + "? (mínimo 2, máximo 6): ");
            numJugadores = sc.nextInt();
            sc.nextLine();

            if (numJugadores >= 2 && numJugadores <= 6) {
                jugadoresValidos = true;
            } else {
                System.out.println("Numero de jugadores entre 2 y 6");
            }
        } while (!jugadoresValidos);

        datosJugadores(numJugadores, nombreEquipo, fechaFundacion);
    }
}
    public static void datosJugadores(int numJugadores, String nombreEquipo, LocalDate fechaFundacion) {
        System.out.println("Nombre del jugador " + nombreEquipo);
        System.out.println("Fecha de fundación del equipo: " + fechaFundacion.format(formatoFecha));

        for (int numJugador = 1; numJugador <= numJugadores; numJugador++) {
            System.out.println("Jugador " + numJugador + ":");

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
                    if (edad >= 15 && edad <= 66) { // mayor de 14 y menor de 67
                        fechaValida = true;
                    } else {
                        System.out.println("La edad del jugador debe ser entre 15 y 66 años.");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Formato invalido, usa dd/MM/yyyy");
                }
            } while (!fechaValida);
            System.out.print("Nickname: ");
            String nickname = sc.nextLine();

            System.out.print("Rol: ");
            String rol = sc.nextLine();


            double sueldo = 0;
            boolean sueldoValido = false;
            do {
                try {
                    System.out.print("Sueldo (€): ");
                    sueldo = sc.nextDouble();
                    sc.nextLine();

                    if (sueldo > SALARIO_MINIMO) {
                        sueldoValido = true;
                    } else {
                        System.out.printf("Sueldo debe ser mayor al salario minimo ", SALARIO_MINIMO);
                    }
                } catch (Exception e) {
                    System.out.println("Introduce el sueldo mayor de 1500€");
                    sc.nextLine();
                }
            } while (!sueldoValido);

            System.out.println("Jugador registrado correctamente:");
            System.out.println("Nombre completo: " + nombre + " " + apellido);
            System.out.println("Nacionalidad: " + nacionalidad);
            System.out.println("Fecha de nacimiento: " + fechaNacimiento.format(formatoFecha));
            System.out.println("Nickname: " + nickname);
            System.out.println("Rol: " + rol);
            System.out.println("Sueldo: " + sueldo);

            System.out.println("Resumen del equipo " + nombreEquipo + ":");
            System.out.println("Jugador: " + nombre + " | Rol: " + rol);
        }
    }
}

