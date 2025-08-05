public class Main {
    package modelados;

public class Batalla {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int rondasTotales;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2, int rondasTotales) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.rondasTotales = rondasTotales;
    }

    // Getters
    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    public Entrenador getEntrenador2() {
        return entrenador2;
    }

    public int getRondasTotales() {
        return rondasTotales;
    }
}
}
