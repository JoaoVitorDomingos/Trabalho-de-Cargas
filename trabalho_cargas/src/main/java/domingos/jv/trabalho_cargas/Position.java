package domingos.jv.trabalho_cargas;

public enum Position {
    // Representação da posição da partícula
    LEFT(40), CENTER(150), RIGHT(260), TOP(30), MIDDLE(90), BOTTOM(150);
    
    private int valor;

    private Position(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
