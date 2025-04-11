package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca3 extends TeclaBlanca{
    TeclaBlanca3(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int x = (int) posicion.getX();
        int N = TeclaNegra.ANCHURA;
        int B = TeclaBlanca.ANCHURA;

        return new int[]{
                x,
                x+B-N,
                x+B-N,
                x+B,
                x + B,
                x
        };
    }

    @Override
    protected int[] getVerticesY() {
        int y = (int) posicion.getY();
        int N = TeclaNegra.ALTURA;
        int B = TeclaBlanca.ALTURA;

        return new int[]{
                y+N,
                y+N,
                y,
                y,
                y + B,
                y + B
        };
    }
}
