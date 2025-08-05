public class Main {
    package modelados;

public class HabilidadEspecial {
    private String nombre;
    private String efecto;
    private int probabilidad;

    public HabilidadEspecial(String nombre, String efecto, int probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.probabilidad = probabilidad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    // Método para verificar si la habilidad se activa
    public boolean seActiva() {
        int random = (int) (Math.random() * 100);
        return random <= probabilidad;
    }
}
}
