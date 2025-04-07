package jd.piano.teclas;

import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;

import java.awt.*;

public class ElementoVisualTester {
    private Graphics graphics;
    private ElementoVisual elemento;

    public ElementoVisualTester(Graphics g){
        this.graphics = g;
        this.elemento = null;
    }

    public ElementoVisualTester(){
        Consola c = new Consola();
        c.getCapaFondo().setFondo(new FondoColorSolido(Color.GRAY));
        this.graphics = c.getCapaCanvas().getGraphics();
        this.elemento = null;
    }

    public void setElementoVisual(ElementoVisual e){
        this.elemento = e;
    }

    public boolean hacerPrueba(){
        throw new UnsupportedOperationException("No programado");
    }
}
