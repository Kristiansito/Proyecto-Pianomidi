package jd.piano.teclas;

import java.awt.*;

public interface ElementoVisual {
    public abstract void setPosicion(int x, int y);
    public void setGraphics(Graphics g);
    public void dibujar();
}
