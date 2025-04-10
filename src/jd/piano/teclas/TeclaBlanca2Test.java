package jd.piano.teclas;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaBlanca2Test {
    @Test
    public void test1(){
        TeclaBlanca2 teclaBlanca2 = new TeclaBlanca2(62);
        teclaBlanca2.setColorPulsado(Color.BLUE);

        ElementoVisualTester e1 = new ElementoVisualTester();
        e1.setElementoVisual(teclaBlanca2);

        boolean resultado = e1.hacerPrueba();

        assertTrue(resultado);
    }

}