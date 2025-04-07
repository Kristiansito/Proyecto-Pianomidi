package jd.piano.teclas;

import java.awt.*;

public class TeclaNegra extends Tecla{
    public static final int ANCHURA = 15;
    public static final int ALTURA = 50;

    TeclaNegra(int n){
        super(n);
    }

    @Override
    public Color getColorNoPulsado() {
        return Color.BLACK;
    }

    @Override
    public int getAnchura() {
        return TeclaNegra.ANCHURA;
    }

    @Override
    public int getAltura() {
        return TeclaNegra.ALTURA;
    }

    @Override
    protected int[] getVerticesX() {
        int x = super.posicion.x;
        int[] verticesX = {x, x, x+TeclaNegra.ANCHURA, x+TeclaNegra.ANCHURA};
        return verticesX;
    }

    @Override
    protected int[] getVerticesY() {
        int y = super.posicion.y;
        int[] verticesY = {y, y+TeclaNegra.ALTURA, y+TeclaNegra.ALTURA, y};
        return verticesY;
    }
}
