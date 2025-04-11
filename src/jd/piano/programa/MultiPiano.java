package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano {
    private List<PianoSencillo> pianos;

    public MultiPiano(int ti, int tf){
        super();
        this.pianos = new ArrayList<>();
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
        for (PianoSencillo p : this.pianos){
            p.dibujar();
        }
    }

    @Override
    public void setPosicion(int x, int y) {
        final int filas = 8;
        final int columnas = 2;

        int nPiano = 0;

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                int coordX = x + j * this.pianos.get(nPiano).getAnchura();
                int coordY = y + i * this.pianos.get(nPiano).getAltura();

                this.pianos.get(nPiano).setPosicion(coordX + coordX/50, coordY + coordY/10);
                nPiano++;
            }
        }
    }

    @Override
    public void setGraphics(Graphics g) {
        for (PianoSencillo p : this.pianos){
            p.setGraphics(g);
        }
    }

    @Override
    public int getAnchura() {
        return this.pianos.get(0).getAnchura();
    }

    @Override
    public int getAltura() {
        return this.pianos.get(0).getAltura();
    }
}
