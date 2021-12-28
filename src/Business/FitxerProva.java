package Business;

import Persistence.ProvaCSV;
import Presentation.Menu;

import java.util.ArrayList;

/**
 * Classe on fem les accions de mostrar i moficiar el contingut del fitxer i de la llista.
 */
public class FitxerProva {
    private ArrayList<Prova> proves;
    private ProvaCSV provaCSV;

    /**
     * Constructor base de la classe
     * @param provaCSV Fitxer del csv
     */
    public FitxerProva(ProvaCSV provaCSV) {
        this.proves = new ArrayList<Prova>();
        this.proves = provaCSV.llegirDades();
        this.provaCSV = provaCSV;
    }

    public FitxerProva(){
    }

    /**
     * Mètode que afegeix una nova prova a la llista i al csv.
     * @param nomProva Nom de la prova
     * @param nomRevista Nom de la revista
     * @param quatille Quartil
     * @param accProb Probabilitat de ser acceptada
     * @param revProb Probabilitat de ser revisada
     * @param rejProb Probabilitat de ser rebutjada
     */
    public void afegirProva(String nomProva, String nomRevista, String quatille, int accProb, int revProb, int rejProb){
        proves.add(new Prova(nomProva, nomRevista, quatille, accProb, revProb, rejProb));
        provaCSV.addProva(nomProva, nomRevista, quatille, accProb, revProb, rejProb);
    }

    /**
     * Mètode on mostrem el nom de totes les proves que hi ha en la llista de proves
     * @return El número de opcions que mostra el menu, sumem 1 per l'opció back.
     */
    public int mostrarTotesProves(){
        int i;
        for (i = 0; i < proves.size(); i++) {
            System.out.println(i+1 + ") " + proves.get(i).getNomProva());
        }
        System.out.println();
        System.out.println(i+1 + ") Back");
        return i+1;
    }

    /**
     * Mètode on mostrem la informació de la prova seleccionada
     * @param numProva La posició de la llista on es troba la prova en qüestió
     */
    public void mostraInformacioProva(int numProva){
        System.out.println("Trial: " + proves.get(numProva - 1).getNomProva() + " (Paper publication)");
        System.out.println("Journal: " + proves.get(numProva - 1).getNomRevista() + "(" + proves.get(numProva - 1).getQuartil() + ")");
        System.out.println("Chances: " + proves.get(numProva - 1).getProbabilitatArticle() + "% acceptance, " + proves.get(numProva - 1).getProbabilitatRevisio()
                            + "% revision, " + proves.get(numProva- 1).getProbabilitatRebuig() + "% rejection");
    }

    /**
     * Mètode encarregat de eliminar una prova del csv i de la llista
     * @param numProva El número de la posició en la llista de la prova
     * @param nomProva El nom de la prova
     * @return Booleà que indica que les proves coincideixin.
     */
    public boolean eliminarProva(int numProva, String nomProva){
        if (nomProva.equals(proves.get(numProva - 1).getNomProva())){
            System.out.println(proves.get(numProva - 1).getNomProva());
            proves.remove(numProva - 1);
            provaCSV.reescriureDades();
            return true;
        }else {
            System.out.println("Error: The trials don't match!");
            return false;
        }
    }
}
