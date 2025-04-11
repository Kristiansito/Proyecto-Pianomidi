package jd.piano.teclas;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
public class TeclaBlanca1Test {
    @Test
    public void test1(){
        TeclaBlanca1 teclaBlanca1 = new TeclaBlanca1(60);
        teclaBlanca1.setColorPulsado(Color.BLUE);

        ElementoVisualTester e1 = new ElementoVisualTester();
        e1.setElementoVisual(teclaBlanca1);

        boolean resultado = e1.hacerPrueba();

        if (!resultado) {
            fail("La prueba falló: ElementoVisualTester.hacerPrueba() devolvió false.");
        }
    }
}