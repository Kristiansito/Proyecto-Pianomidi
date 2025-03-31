package jd.piano.teclas;

import java.awt.*;

public abstract class Tecla {
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;

    Tecla(int n){
        throw new UnsupportedOperationException("Sin programar");
    }

    public int getNumeroNota(){
        throw new UnsupportedOperationException("Sin programar");
    }

    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();
}
