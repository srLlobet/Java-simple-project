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

    public int getNombreJugadors() {
        return nombreJugadors;
    }

    public int getNombreProves() {
        return nombreProves;
    }

    public ArrayList<String> getLlistaProves() {
        return llistaProves;
    }

}
