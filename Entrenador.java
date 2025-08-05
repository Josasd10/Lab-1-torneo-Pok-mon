public class Main {
    package modelados;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pokemon> pokemons;
    private int rondasGanadas;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemons = new ArrayList<>();
        this.rondasGanadas = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    // Métodos
    public void agregarPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void incrementarRondasGanadas() {
        rondasGanadas++;
    }

    public Pokemon elegirPokemon(int indice) {
        return pokemons.get(indice);
    }
}
}
