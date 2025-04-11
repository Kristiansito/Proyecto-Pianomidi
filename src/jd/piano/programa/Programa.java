package jd.piano.programa;

import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import bpc.daw.consola.FondoColorSolido;
import bpc.daw.consola.FondoImagen;
import jd.piano.teclas.Piano;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        Consola c = new Consola();
        CapaTexto ct = c.getCapaTexto();
        try{
            BufferedImage cargarImagen = ImageIO.read(new File("fondo.jpg"));
            FondoImagen imagenFondo = new FondoImagen(cargarImagen);
            c.getCapaFondo().setFondo(imagenFondo);
            imagenFondo.setEscalado(true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String ruta = "";
        File carpetaCanciones = new File("./songs");
        List<File> listaCanciones = new ArrayList<>();

        if (carpetaCanciones.exists() && carpetaCanciones.isDirectory()) {
            File[] archivos = carpetaCanciones.listFiles();
            if (archivos != null) {
                for (File f : archivos) {
                    if (f.isFile()) {
                        listaCanciones.add(f);
                    }
                }
            }
        }

        if (!listaCanciones.isEmpty()) {
            int nMaximo = listaCanciones.size();
            ct.println("Seleccione una opción (0-" + nMaximo + "):");
            ct.println("0. Ruta personalizada");
            for (int i = 0; i < nMaximo; i++) {
                ct.println((i + 1) + ". " + listaCanciones.get(i).getName());
            }
            int opcion = c.getTeclado().leerNumeroEntero();
            ct.cls();

            if (opcion == 0) {
                ct.println("Escribe la ruta de un archivo:");
                ruta = c.getTeclado().leerCadenaCaracteres();
            } else if (opcion >= 1 && opcion <= nMaximo) {
                ruta = listaCanciones.get(opcion - 1).getPath();
            } else {
                ct.println("Opción no válida.");
            }
        } else {
            ct.println("El directorio './songs' no existe o no contiene canciones.");
            ct.println("Escribe la ruta de un archivo:");
            ruta = c.getTeclado().leerCadenaCaracteres();
        }

        if (!new File(ruta).exists()) {
            ct.println("El archivo no existe.");
        } else {
            ct.println("""
                    ¿Dónde desea reproducir la canción?
                    1. Piano Sencillo
                    2. Multi Piano
                    """);
            int opcionPiano = c.getTeclado().leerNumeroEntero();
            Piano p = null;
            switch (opcionPiano) {
                case 1 -> p = new PianoSencillo(24, 108);
                case 2 -> p = new MultiPiano(24, 108);
                default -> {
                    ct.println("Opción inválida");
                }
            }
            ct.cls();
            p.setGraphics(c.getCapaCanvas().getGraphics());
            if (p instanceof PianoSencillo) {
                p.setPosicion(
                        Toolkit.getDefaultToolkit().getScreenSize().width / 2 - p.getAnchura() / 2,
                        Toolkit.getDefaultToolkit().getScreenSize().height / 2 - p.getAltura() / 2
                );
            } else {
                p.setPosicion(0, 0);
            }
            ReproductorMidi r = new ReproductorMidi();
            r.conectar(p);
            r.reproducir(ruta);
            r.close();
        }
    }
}
