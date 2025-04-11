package jd.piano.teclas;

import java.awt.*;

public class TeclaBlanca1 extends TeclaBlanca{
    TeclaBlanca1(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int x = (int) posicion.getX();
        int B = TeclaBlanca.ANCHURA;
        int N = TeclaNegra.ANCHURA;

        // Se define el array de X, incluyendo la muesca para la tecla negra
        return new int[]{
                x,
                x,
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

        // Se define el array de Y para el polígono
        return new int[]{
                y,
                y,
                y + N,
                y + N,
                y + B,
                y + B
        };
    }
}
