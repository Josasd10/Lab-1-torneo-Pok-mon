public class Main {
    package controladores;

import modelados.*;

public class ControladorBatalla {
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static int calcularAtaqueTotal(Pokemon atacante, Pokemon defensor, boolean usaHabilidad) {
        int ataqueTotal = atacante.getAtaque();
        
        // Aplicar efecto de tipo
        int modificadorTipo = atacante.calcularModificadorTipo(defensor);
        ataqueTotal += modificadorTipo;
        
        // Aplicar habilidad si se usa y se activa
        if (usaHabilidad && atacante.getHabilidad().seActiva()) {
            String efecto = atacante.getHabilidad().getEfecto();
            if (efecto.contains("ataque")) {
                int aumento = Integer.parseInt(efecto.replaceAll("[^0-9]", ""));
                ataqueTotal += aumento;
            }
        }
        
        // Restar defensa del oponente
        ataqueTotal -= defensor.getDefensa();
        
        return ataqueTotal;
    }

    public static void determinarGanadorRonda(Entrenador e1, Pokemon p1, int ataque1, 
                                             Entrenador e2, Pokemon p2, int ataque2) {
        if (ataque1 > ataque2) {
            e1.incrementarRondasGanadas();
            mostrarMensaje(e1.getNombre() + " gana la ronda con " + p1.getNombre() + 
                          " (Ataque total: " + ataque1 + " vs " + ataque2 + ")");
        } else if (ataque2 > ataque1) {
            e2.incrementarRondasGanadas();
            mostrarMensaje(e2.getNombre() + " gana la ronda con " + p2.getNombre() + 
                          " (Ataque total: " + ataque2 + " vs " + ataque1 + ")");
        } else {
            mostrarMensaje("Empate en esta ronda (" + ataque1 + " vs " + ataque2 + ")");
        }
    }

    public static void anunciarGanadorFinal(Entrenador e1, Entrenador e2) {
        int rondas1 = e1.getRondasGanadas();
        int rondas2 = e2.getRondasGanadas();
        
        mostrarMensaje("\n=== RESULTADO FINAL ===");
        mostrarMensaje(e1.getNombre() + ": " + rondas1 + " rondas ganadas");
        mostrarMensaje(e2.getNombre() + ": " + rondas2 + " rondas ganadas");
        
        if (rondas1 > rondas2) {
            mostrarMensaje("¡" + e1.getNombre() + " es el ganador del torneo!");
        } else if (rondas2 > rondas1) {
            mostrarMensaje("¡" + e2.getNombre() + " es el ganador del torneo!");
        } else {
            mostrarMensaje("¡El torneo termina en empate!");
        }
    }
}
}
