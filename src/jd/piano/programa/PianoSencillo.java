package jd.piano.programa;

import jd.piano.teclas.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano {
    private Map<Integer, Tecla> teclas;

    public PianoSencillo(int teclaInicial, int teclaFinal) {
        super();
        this.teclas = new HashMap<>();
        // He tenido que poner protected en la clase padre
        this.teclaFinal = teclaFinal;
        this.teclaInicial = teclaInicial;

        for (int nota = teclaInicial; nota <= teclaFinal; nota++) {
            Tecla tecla = TeclaFactory.crearTecla(nota);
            this.teclas.put(nota, tecla);
        }
    }

    @Override
    public void setGraphics(Graphics g) {
        for (Tecla tecla : this.teclas.values()) {
            tecla.setGraphics(g);
        }
    }

    @Override
    public void dibujar() {
        for (Tecla tecla : this.teclas.values()) {
            tecla.dibujar();
        }
    }

    @Override
    public void setPosicion(int x, int y) {
        int x1 = x;
        int y1 = y;

        for (Tecla tecla : this.teclas.values()) {
            if (tecla instanceof TeclaBlanca) {
                tecla.setPosicion(x1, y1);
                x1 += tecla.getAnchura();
            }
            else if (tecla instanceof TeclaNegra) {
                tecla.setPosicion(x1 - TeclaNegra.ANCHURA / 2, y1);
            }
        }
        dibujar();
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }

    @Override
    public int getAnchura() {
        int anchura = 0;
        for (Tecla tecla : teclas.values()) {
            if (tecla instanceof TeclaBlanca) {
                anchura += tecla.getAnchura();
            }
        }
        return anchura;
    }

    @Override
    public int getAltura() {
        int altura = 0;
        for (Tecla t : teclas.values()) {
            if (t.getAltura() > altura) {
                altura = t.getAltura();
            }
        }
        return altura;
    }
}
