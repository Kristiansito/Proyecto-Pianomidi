package jd.piano.teclas;

import java.awt.*;

public class TeclaNegra extends Tecla{
    public static final int ANCHURA = 15;
    public static final int ALTURA = 50;

    TeclaNegra(int n){
        super(n);
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public Color getColorNoPulsado() {
        return null;
    }

    @Override
    public int getAnchura() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }

    @Override
    protected int[] getVerticesX() {
        return new int[0];
    }

    @Override
    protected int[] getVerticesY() {
        return new int[0];
    }
}
