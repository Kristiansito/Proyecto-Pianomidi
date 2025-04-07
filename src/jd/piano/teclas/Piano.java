package jd.piano.teclas;

import javax.swing.text.Position;
import java.awt.*;

public abstract class Piano implements ElementoVisual{
    private int teclaInicial;
    private int teclaFinal;
    private Position posicion;
    private Graphics graphics;

    public Piano(){
        throw new UnsupportedOperationException("No programado");
    }
    public abstract Tecla getTecla(int canal, int nota);
    public int getTeclaInicial(){
        throw new UnsupportedOperationException("No programado");
    }
    public int getTeclaFinal(){
        throw new UnsupportedOperationException("No programado");
    }
}
