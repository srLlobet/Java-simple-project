package Business;

import java.util.ArrayList;

public class Edicio {
    private int anyEdicio;
    private int nombreJugadors;
    private int nombreProves;
    private ArrayList<String> llistaProves;

    public Edicio(int anyEdicio, int nombreJugadors, int nombreProves, ArrayList<String> llistaProves) {
        this.anyEdicio = anyEdicio;
        this.nombreJugadors = nombreJugadors;
        this.nombreProves = nombreProves;
        this.llistaProves = llistaProves;
    }

    public int getAnyEdicio() {
        return anyEdicio;
    }

    public void setAnyEdicio(int anyEdicio) {
        this.anyEdicio = anyEdicio;
    }

    public int getNombreJugadors() {
        return nombreJugadors;
    }

    public void setNombreJugadors(int nombreJugadors) {
        this.nombreJugadors = nombreJugadors;
    }

    public int getNombreProves() {
        return nombreProves;
    }

    public void setNombreProves(int nombreProves) {
        this.nombreProves = nombreProves;
    }

    public ArrayList<String> getLlistaProves() {
        return llistaProves;
    }

    public void setLlistaProves(ArrayList<String> llistaProves) {
        this.llistaProves = llistaProves;
    }
}
