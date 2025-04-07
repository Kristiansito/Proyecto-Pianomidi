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
        this.elemento.setPosicion(120, 90);
        this.elemento.setGraphics(this.graphics);

        this.elemento.dibujar();

        if (this.elemento instanceof Pulsable){
            try{
                ((Pulsable) this.elemento).setColorPulsado(Color.BLUE);
                Thread.sleep(2000);
                ((Pulsable) this.elemento).pulsar();
                Thread.sleep(2000);
                ((Pulsable) this.elemento).soltar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Consola c = new Consola();
        c.getCapaTexto().println("¿Ha salido el test bien?");
        char letra = c.getTeclado().leerCaracter();
        boolean b = true;
        if (letra !='s' && letra != 'S'){
            b = false;
        }
        return b;
    }
}
