package jd.piano.teclas;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaBlanca3Test {
    @Test
    public void test1(){
        TeclaBlanca3 teclaBlanca3 = new TeclaBlanca3(64);
        teclaBlanca3.setColorPulsado(Color.BLUE);

        ElementoVisualTester e1 = new ElementoVisualTester();
        e1.setElementoVisual(teclaBlanca3);

        boolean resultado = e1.hacerPrueba();

        if (!resultado) {
            fail("La prueba falló: ElementoVisualTester.hacerPrueba() devolvió false.");
        }
    }

}