package jd.piano.programa;

import jd.piano.teclas.Piano;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import java.awt.*;

public class ReprodcutorMidi implements Receiver {
    private static final Color[] COLORES;
    private PianoMidi piano;

    public ReprodcutorMidi(){
        throw new UnsupportedOperationException("No programado");
    }
    public void conectar(Piano p){
        throw new UnsupportedOperationException("No programado");
    }
    public void reproducir(String ruta){
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        throw new UnsupportedOperationException("No programado");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("No programado");
    }
}
