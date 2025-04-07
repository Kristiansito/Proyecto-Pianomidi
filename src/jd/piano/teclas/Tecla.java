package jd.piano.teclas;

import java.awt.*;

public abstract class Tecla implements Pulsable {
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;

    Tecla(int n){
        this.posicion = null;
        this.colorPulsada = null;
        this.pulsada = false;
        this.nota = n;
    }

    public int getNumeroNota(){
        return this.nota;
    }

    @Override
    public void pulsar(){
        this.pulsada = true;
    }

    @Override
    public void soltar(){
        this.pulsada = false;
    }

    @Override
    public void dibujar(){
        if (this.posicion == null || this.graphics == null){
            throw new IllegalStateException("Hay que llamar a setPosicion y setGraphics antes de llamar al metodo dibujar");
        }

        this.graphics.setColor(this.getColor());

        int [] xPoints = this.getVerticesX();
        int [] yPoints = this.getVerticesY();
        this.graphics.fillPolygon(xPoints, yPoints, xPoints.length);

        this.graphics.setColor(Color.BLACK);
        this.graphics.drawPolygon(xPoints, yPoints, xPoints.length);
    }

    @Override
    public void setColorPulsado(Color c){
        this.colorPulsada = c;
    }

    @Override
    public boolean estaPulsado(){
        return this.pulsada;
    }

    @Override
    public Color getColorPulsado(){
        return this.colorPulsada;
    }

    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();
}
