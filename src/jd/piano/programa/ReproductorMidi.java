package jd.piano.programa;

import jd.piano.teclas.Piano;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import java.awt.*;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES = {Color.CYAN, Color.BLUE, Color.GREEN, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.YELLOW, Color.RED, Color.DARK_GRAY, Color.LIGHT_GRAY,
            new Color(64, 236, 127), new Color(227, 162, 84), new Color(174, 246, 12),
            new Color(113, 172, 209), new Color(202, 184, 155), new Color(50, 142, 72)};
    private Piano piano;

    public ReproductorMidi(){
        this.piano = null;
    }
    public void conectar(Piano p){
        this.piano = p;
    }
    public void reproducir(String ruta){
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public void close() {}
}
