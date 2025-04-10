package jd.piano.teclas;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;
import org.junit.Test;

import java.awt.*;

public class TeclaFactoryTest {
    @Test
    public void test1(){
        Consola c = new Consola();
        CapaCanvas cv = c.getCapaCanvas();
        Graphics g = cv.getGraphics();

        g.setColor(Color.GRAY);

        ElementoVisualTester elemento = new ElementoVisualTester(g);

        for(int i =60;i<=64;i++){
            elemento.setElementoVisual(TeclaFactory.crearTecla(i));
            if(elemento.hacerPrueba()){
                cv.cls();
            }
        }
    }
}