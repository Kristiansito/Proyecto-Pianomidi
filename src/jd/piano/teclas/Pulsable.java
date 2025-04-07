package jd.piano.teclas;

import java.awt.*;

public interface Pulsable extends ElementoVisual{
    public abstract void pulsar();
    public abstract void soltar();
    public abstract boolean estaPulsado();
    public abstract void setColorPulsado();
    public abstract Color getColorPulsado();
    public abstract Color getColorNoPulsado();
    public default Color getColor(){
        throw new UnsupportedOperationException("No programado");
    }
}
