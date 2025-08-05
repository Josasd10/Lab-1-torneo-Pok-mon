public class Main {
    package mains;

import modelados.*;
import controladores.ControladorBatalla;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear habilidades especiales
        HabilidadEspecial llamaFinal = new HabilidadEspecial("Llama Final", "+15 ataque", 30);
        HabilidadEspecial escudoNatural = new HabilidadEspecial("Escudo Natural", "+20 defensa", 40);
        HabilidadEspecial impactoRapido = new HabilidadEspecial("Impacto Relámpago", "-10 ataque", 25);
        HabilidadEspecial raizCurativa = new HabilidadEspecial("Raíz Curativa", "+10 defensa", 35);
        
        // Crear pokémons
        Pokemon charmander = new Pokemon("Charmander", "Fuego", 50, 30, llamaFinal);
        Pokemon squirtle = new Pokemon("Squirtle", "Agua", 45, 40, escudoNatural);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Planta", 48, 35, raizCurativa);
        Pokemon pikachu = new Pokemon("Pikachu", "Eléctrico", 55, 25, impactoRapido);
        
        Pokemon charizard = new Pokemon("Charizard", "Fuego", 65, 45, llamaFinal);
        Pokemon blastoise = new Pokemon("Blastoise", "Agua", 60, 55, escudoNatural);
        Pokemon venusaur = new Pokemon("Venusaur", "Planta", 62, 50, raizCurativa);
        Pokemon raichu = new Pokemon("Raichu", "Eléctrico", 70, 40, impactoRapido);
        
        // Crear entrenadores
        Entrenador ash = new Entrenador("Ash");
        ash.agregarPokemon(charmander);
        ash.agregarPokemon(squirtle);
        ash.agregarPokemon(bulbasaur);
        ash.agregarPokemon(pikachu);
        
        Entrenador brock = new Entrenador("Brock");
        brock.agregarPokemon(charizard);
        brock.agregarPokemon(blastoise);
        brock.agregarPokemon(venusaur);
        brock.agregarPokemon(raichu);
        
        // Crear batalla
        Batalla batalla = new Batalla(ash, brock, 4);
        
        // Iniciar batalla
        ControladorBatalla.mostrarMensaje("¡Comienza el torneo Pokémon!");
        
        for (int ronda = 1; ronda <= batalla.getRondasTotales(); ronda++) {
            ControladorBatalla.mostrarMensaje("\n=== RONDA " + ronda + " ===");
            
            // Seleccionar pokémons
            Pokemon pokemonAsh = ash.elegirPokemon(ronda - 1);
            Pokemon pokemonBrock = brock.elegirPokemon(ronda - 1);
            
            ControladorBatalla.mostrarMensaje(ash.getNombre() + " elige a " + pokemonAsh.getNombre());
            ControladorBatalla.mostrarMensaje(brock.getNombre() + " elige a " + pokemonBrock.getNombre());
            
            // Decidir acciones (simplificado para el ejemplo)
            boolean ashUsaHabilidad = Math.random() > 0.5;
            boolean brockUsaHabilidad = Math.random() > 0.5;
            
            // Calcular ataques totales
            int ataqueAsh = ControladorBatalla.calcularAtaqueTotal(pokemonAsh, pokemonBrock, ashUsaHabilidad);
            int ataqueBrock = ControladorBatalla.calcularAtaqueTotal(pokemonBrock, pokemonAsh, brockUsaHabilidad);
            
            // Determinar ganador de la ronda
            ControladorBatalla.determinarGanadorRonda(ash, pokemonAsh, ataqueAsh, brock, pokemonBrock, ataqueBrock);
        }
        
        // Anunciar ganador final
        ControladorBatalla.anunciarGanadorFinal(ash, brock);
        
        scanner.close();
    }
}
}
