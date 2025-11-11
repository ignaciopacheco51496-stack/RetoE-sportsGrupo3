import javax.swing.*;
import java.awt.Dimension;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            iniciarGestion();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Operación cancelada por el usuario.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void iniciarGestion() {

        Map<String, List<String>> gestionTotalEquipos = new HashMap<>();
        List<String> nombresEquipos = new ArrayList<>();


        int numEquipos = 0;
        boolean numeroValido = false;

        do {
            String strNumEquipos = JOptionPane.showInputDialog(null,
                    "Ingrese el número total de equipos (debe ser par):",
                    "Gestión de Torneo",
                    JOptionPane.QUESTION_MESSAGE);

            if (strNumEquipos == null) {
                throw new NullPointerException("Operación cancelada.");
            }

            try {
                numEquipos = Integer.parseInt(strNumEquipos);

                if (numEquipos < 2) {
                    JOptionPane.showMessageDialog(null, "Se necesitan al menos 2 equipos.", "Error", JOptionPane.WARNING_MESSAGE);
                } else if (numEquipos % 2 != 0) {
                    JOptionPane.showMessageDialog(null, "El número de equipos debe ser par.", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    numeroValido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor no numérico. Intente de nuevo.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } while (numeroValido == false);


        Pattern patronNombreValido = Pattern.compile("^[a-zA-Z0-9 ]+$");

        for (int i = 0; i < numEquipos; i++) {

            String nombreEquipo;
            boolean nombreValido = false;

            do {
                nombreEquipo = JOptionPane.showInputDialog(null,
                        "Ingrese el nombre del EQUIPO #" + (i + 1) + ":",
                        "Registro de Equipos",
                        JOptionPane.PLAIN_MESSAGE);

                if (nombreEquipo == null) {
                    throw new NullPointerException("Registro de equipo cancelado.");
                }

                Matcher matcher = patronNombreValido.matcher(nombreEquipo);

                if (matcher.matches()) {
                    nombreValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre del equipo no puede estar vacío y debe contener solo letras, números o espacios.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } while (nombreValido == false);


            int numJugadores = 0;
            while (numJugadores < 2 || numJugadores > 6) {
                String strNumJugadores = JOptionPane.showInputDialog(null,
                        "¿Cuántos jugadores tiene '" + nombreEquipo + "'?\n(Mínimo 2, Máximo 6)",
                        "Registro de Jugadores",
                        JOptionPane.QUESTION_MESSAGE);

                numJugadores = Integer.parseInt(strNumJugadores);

                if (numJugadores < 2 || numJugadores > 6) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto. Debe ser entre 2 y 6.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                }
            }

            List<String> jugadoresDelEquipo = new ArrayList<>();
            for (int j = 0; j < numJugadores; j++) {

                String nombreJugador;
                boolean jugadorValido = false;

                do {
                    nombreJugador = JOptionPane.showInputDialog(null,
                            "Nombre del JUGADOR #" + (j + 1) + " (Equipo: " + nombreEquipo + "):",
                            "Registro de Jugadores",
                            JOptionPane.PLAIN_MESSAGE);

                    if (nombreJugador == null) {
                        throw new NullPointerException("Registro de jugador cancelado.");
                    }

                    Matcher matcher = patronNombreValido.matcher(nombreJugador);

                    if (matcher.matches()) {
                        jugadorValido = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre del jugador no puede estar vacío y debe contener solo letras, números o espacios.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } while (jugadorValido == false);

                jugadoresDelEquipo.add(nombreJugador);
            }

            gestionTotalEquipos.put(nombreEquipo, jugadoresDelEquipo);
            nombresEquipos.add(nombreEquipo);
        }

        mostrarResultados(gestionTotalEquipos, nombresEquipos);
    }

    public static void mostrarResultados(Map<String, List<String>> equipos, List<String> nombresEquipos) {

        StringBuilder resumen = new StringBuilder();
        resumen.append("===== RESUMEN DE EQUIPOS REGISTRADOS =====\n\n");

        for (Map.Entry<String, List<String>> entry : equipos.entrySet()) {
            resumen.append("--- Equipo: ").append(entry.getKey()).append(" ---\n");
            resumen.append("   Jugadores: ").append(entry.getValue().toString()).append("\n\n");
        }

        resumen.append("\n===== CALENDARIO DE PARTIDOS (Todos vs Todos) =====\n\n");
        for (int i = 0; i < nombresEquipos.size(); i++) {
            for (int j = i + 1; j < nombresEquipos.size(); j++) {
                String equipoLocal = nombresEquipos.get(i);
                String equipoVisitante = nombresEquipos.get(j);
                resumen.append("Jornada: ").append(equipoLocal).append("  vs  ").append(equipoVisitante).append("\n");
            }
        }

        JTextArea textArea = new JTextArea(resumen.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(null,
                scrollPane,
                "Gestión de Torneo Completada",
                JOptionPane.INFORMATION_MESSAGE);
    }
}