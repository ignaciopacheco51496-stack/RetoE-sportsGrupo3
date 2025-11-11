import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);




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
        for (int i = 1; i <= equipos; i++) {
            System.out.println("Nombre del equipo " + i);
            String nombre = sc.next();


            System.out.println("Fecha de fecha de fundación " + i);
            int fecha  = sc.nextInt();


            datosJuagadores();
        }
    }


    public static void main(String[] args) {
        inscribirEquipos();
    }
}

