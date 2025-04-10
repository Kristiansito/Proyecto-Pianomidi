package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import java.awt.*;
import java.util.List;

public class MultiPiano extends Piano {
    private List<PianoSencillo> pianos;

    public MultiPiano(int ti, int tf){
        super();
        for (int i = 0; i<16; i++){
            this.pianos.add(new PianoSencillo(ti, tf));
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.pianos.get(canal).getTecla(canal, nota);
    }

    @Override
    public void dibujar() {
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public void setPosicion(int x, int y) {
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public void setGraphics(Graphics g) {
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public int getAnchura() {
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public int getAltura() {
        throw new UnsupportedOperationException("No programado");
    }
}
