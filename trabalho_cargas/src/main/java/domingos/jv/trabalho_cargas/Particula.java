package domingos.jv.trabalho_cargas;

import java.awt.geom.Ellipse2D;

public class Particula {
    private int carga;
    private Ellipse2D.Float forma;
    private Position posX;
    private Position posY;
    private double distancia;

    public Particula(int x, int y) {
        this.forma = new Ellipse2D.Float(x, y, 15, 15);
        this.carga = 0;
        definirPos(x, y);
        calcularDistancia();
    }

    public int getCarga() {
        return carga;
    }

    public Ellipse2D.Float getForma() {
        return forma;
    }

    public Position getPosX() {
        return posX;
    }

    public Position getPosY() {
        return posY;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
    
    private void definirPos(int x, int y) {
        if(x == 40)
            posX = Position.LEFT;
        else if(x == 150)
            posX = Position.CENTER;
        else
            posX = Position.RIGHT;
        
        if(y == 30)
            posY = Position.TOP;
        else if(y == 90)
            posY = Position.MIDDLE;
        else 
            posY = Position.BOTTOM;
    }
    
    private void calcularDistancia() {
        
    }
}
