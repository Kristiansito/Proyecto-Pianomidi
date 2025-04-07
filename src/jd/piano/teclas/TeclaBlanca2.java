package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca2 extends TeclaBlanca{
    TeclaBlanca2(int n){
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
    public void setPosicion(int x, int y) {

    }

    @Override
    public void setGraphics(Graphics g) {

    }
}
