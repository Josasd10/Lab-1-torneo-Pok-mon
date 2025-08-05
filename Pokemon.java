public class Main {
    package modelados;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidad;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public HabilidadEspecial getHabilidad() {
        return habilidad;
    }

    // Método para calcular el modificador de tipo
    public int calcularModificadorTipo(Pokemon oponente) {
        String tipoAtacante = this.tipo;
        String tipoDefensor = oponente.getTipo();

        if (tipoAtacante.equals("Fuego")) {
            if (tipoDefensor.equals("Planta")) return 20;
            if (tipoDefensor.equals("Agua")) return -10;
        } else if (tipoAtacante.equals("Agua")) {
            if (tipoDefensor.equals("Fuego")) return 20;
            if (tipoDefensor.equals("Planta")) return -10;
        } else if (tipoAtacante.equals("Planta")) {
            if (tipoDefensor.equals("Agua")) return 20;
            if (tipoDefensor.equals("Fuego")) return -10;
        } else if (tipoAtacante.equals("Eléctrico")) {
            if (tipoDefensor.equals("Agua")) return 20;
        }

        return 0;
    }
}
}
