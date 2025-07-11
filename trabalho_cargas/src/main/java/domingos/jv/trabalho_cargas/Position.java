package domingos.jv.trabalho_cargas;

public enum Position {
    LEFT(1), CENTER(2), RIGHT(3), TOP(-1), MIDDLE(-2), BOTTOM(-3);
    
    private int valor;

    private Position(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
