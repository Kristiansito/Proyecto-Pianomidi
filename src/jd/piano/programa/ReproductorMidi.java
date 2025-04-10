package jd.piano.programa;

import jd.piano.teclas.Piano;
import jd.piano.teclas.Tecla;

import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMidi implements Receiver {
    private static final Color[] COLORES = {Color.MAGENTA, Color.DARK_GRAY, Color.PINK, Color.RED, Color.LIGHT_GRAY,
            Color.YELLOW, Color.ORANGE, Color.CYAN, Color.GREEN, Color.BLUE,
            new Color(135, 28, 219), new Color(75, 192, 183), new Color(255, 87, 51),
            new Color(199, 0, 139), new Color(144, 238, 144), new Color(255, 215, 0)};
    private Piano piano;

    public ReproductorMidi(){
        this.piano = null;
    }
    public void conectar(Piano p){
        this.piano = p;
    }
    public void reproducir(String ruta){
        try{
            Sequence cancionMidi = MidiSystem.getSequence(new File(ruta));

            Sequencer secuenciador = MidiSystem.getSequencer();
            secuenciador.open();

            Transmitter cable = secuenciador.getTransmitter();

            cable.setReceiver(this);
            secuenciador.setSequence(cancionMidi);

            secuenciador.start();

            Thread.sleep(cancionMidi.getMicrosecondLength()/1000);

            cable.close();
            secuenciador.close();

        } catch (IOException | InvalidMidiDataException | MidiUnavailableException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage) {
            ShortMessage sm = (ShortMessage) message;
            int nCanal = sm.getChannel();
            if (nCanal != 9) {
                int nNotaMusical = sm.getData1();
                Tecla tecla = this.piano.getTecla(nCanal, nNotaMusical);
                if (tecla != null) {
                    int nComando = sm.getCommand();
                    if (nComando == ShortMessage.NOTE_ON) {
                        int volumen = sm.getData2();
                        if (volumen > 0) {
                            tecla.setColorPulsado(COLORES[nCanal]);
                            tecla.pulsar();
                        } else {
                            tecla.soltar();
                        }
                    } else {
                        tecla.soltar();
                    }
                    tecla.dibujar();
                }
            }
        }
    }

    @Override
    public void close() {}
}
