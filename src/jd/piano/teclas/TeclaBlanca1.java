package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca1 extends TeclaBlanca{
    TeclaBlanca1(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int x = posicion.x;
        int B = TeclaBlanca.ANCHURA;
        int N = TeclaNegra.ANCHURA;

        return new int[]{
                x,
                x + B - N / 2,
                x + B,
                x + B,
                x
        };
    }

    @Override
    protected int[] getVerticesY() {
        int y = posicion.y;
        int A = TeclaBlanca.ALTURA;

        return new int[]{
                y,
                y,
                y,
                y +  A,
                y + A
        };
    }
}
