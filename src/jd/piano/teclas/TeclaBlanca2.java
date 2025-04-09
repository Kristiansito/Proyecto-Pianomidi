package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca2 extends TeclaBlanca{
    TeclaBlanca2(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int x = (int) posicion.getX();
        int N = TeclaNegra.ANCHURA;
        int B = TeclaBlanca.ANCHURA;

        return new int[]{
                x,
                x,
                x+N/2,
                x+N/2,
                x+B-N/2,
                x+B-N/2,
                x + B,
                x + B
        };
    }

    @Override
    protected int[] getVerticesY() {
        int y = (int) posicion.getY();
        int N = TeclaNegra.ALTURA;
        int B = TeclaBlanca.ALTURA;

        return new int[]{
                y,
                y,
                y + N,
                y + N,
                y + N,
                y + N,
                y + B,
                y + B
        };
    }
}
