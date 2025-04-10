package jd.piano.teclas;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TeclaNegraTest {
    @Test
    public void test1(){
        Tecla t = new TeclaNegra(61);
        t.setColorPulsado(Color.BLUE);
        ElementoVisualTester e = new ElementoVisualTester();
        e.setElementoVisual(t);
        boolean b = e.hacerPrueba();
        assertTrue(b);
    }
}
