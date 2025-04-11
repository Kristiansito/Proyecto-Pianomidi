package jd.piano.programa;

import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import jd.piano.teclas.Piano;

import java.awt.*;
import java.io.File;

public class Programa {
    public static void main(String[] args) {
        Consola c = new Consola();
        c.getCapaFondo().setFondo(
                new FondoColorSolido(
                        new Color(0,0,70)
                )
        );

        c.getCapaTexto().println("Escribe la ruta de un archivo: ");
        String ruta = c.getTeclado().leerCadenaCaracteres();
        if (!new File(ruta).exists()){
            c.getCapaTexto().println("El archivo no existe.");
        }else {
            c.getCapaTexto().println("""
                    ¿Dónde desea reproducir la canción?
                    1. Piano Sencillo
                    2. Multi Piano
                    """);
            int opcion = c.getTeclado().leerNumeroEntero();

            Piano p = null;
            switch (opcion){
                case 1 -> {
                    p = new PianoSencillo(24, 108);
                }
                case 2 -> {
                    p = new MultiPiano(24, 108);
                }
                default -> {
                    c.getCapaTexto().println("Opción inválida");
                }
            }
            p.setGraphics(c.getCapaCanvas().getGraphics());
            p.setPosicion(0,0);
            ReproductorMidi r = new ReproductorMidi();
            r.conectar(p);
            r.reproducir(ruta);
            r.close();
        }
    }
}
