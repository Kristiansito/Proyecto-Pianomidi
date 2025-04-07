package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca1 extends TeclaBlanca{
    TeclaBlanca1(int n){
        super(n);
        throw new UnsupportedOperationException("Sin programar");
    }

    @Override
    protected int[] getVerticesX() {
        return new int[0];
    }

    @Override
    protected int[] getVerticesY() {
        return new int[0];
    }

    @Override
    public void pulsar() {

    }

    @Override
    public void soltar() {

    }

    @Override
    public boolean estaPulsado() {
        return false;
    }

    @Override
    public Color getColorPulsado() {
        return null;
    }

    @Override
    public Color getColorNoPulsado() {
        return null;
    }

    @Override
    public void setPosicion(int x, int y) {

    }

    @Override
    public void setGraphics(Graphics g) {

    }

    @Override
    public void dibujar() {

    }

    @Override
    public int getAnchura() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }
}
