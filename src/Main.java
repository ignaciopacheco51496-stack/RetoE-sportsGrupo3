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
        menuInscribir();
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
            sc.nextLine();
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

            String rol = "";
            boolean rolValido = false;
            do {
                try {
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
                } catch (Exception e) {
                    System.out.println("Error al leer el rol. Intenta de nuevo.");
                    sc.nextLine();
                }
            } while (!rolValido);


            double sueldo = 0;
            boolean sueldoValido = false;
            do {
                try {
                    System.out.print("Sueldo mayor de 1500: ");
                    sueldo = sc.nextDouble();
                    sc.nextLine();

                    if (sueldo > SALARIO_MINIMO) {
                        sueldoValido = true;
                    } else {
                        System.out.println("Sueldo debe ser mayor al " + SALARIO_MINIMO);
                    }
                } catch (Exception e) {
                    System.out.println("Introduce el sueldo mayor de 1500€");
                    sc.nextLine();
                }
            } while (!sueldoValido);

            System.out.println("Jugador registrado correctamente:");
            System.out.println("Datos del Jugador: " + nombre + " | Rol: " + rol);
        }
    }

    public static void inscribirJugadores() {
        sc.nextLine();
        System.out.println("INSCRIBIR NUEVOS JUGADORES");
        System.out.print("Equipo al que pertenece el jugador: ");
        String nombreEquipo = sc.nextLine();

       datosJugadores(1, nombreEquipo, LocalDate.now());
    }

    public static void menuInscribir() {
        int opcion;
        do{
            System.out.println("  MENU DE INSCRIBCION  ");
            System.out.println("1) INSCRIBIR MAS EQUIPOS");
            System.out.println("2) INSCRIBIR MAS JUGADORES");
            System.out.println("3) SALIR");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    inscribirEquipos();
                    break;
                case 2:
                    inscribirJugadores();
                    break;
                case 3:
                    System.out.println("Cerrando programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 3);
    }
}

