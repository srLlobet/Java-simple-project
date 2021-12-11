package Business;

import Persistence.ProvaCSV;

import java.util.ArrayList;

public class FitxerProva {
    private ArrayList<Prova> proves;
    private ProvaCSV provaCSV;

    public FitxerProva(ProvaCSV provaCSV) {
        this.proves = new ArrayList<Prova>();
        this.proves = provaCSV.llegirDades();
        this.provaCSV = provaCSV;
    }

    public void afegirProva(String nomProva, String nomRevista, String quatille, int accProb, int revProb, int rejProb){
        proves.add(new Prova(nomProva, nomRevista, quatille, accProb, revProb, rejProb));
        provaCSV.addProva(nomProva, nomRevista, quatille, accProb, revProb, rejProb);
    }

    public int mostrarTotesProves(){
        int i;
        for (i = 0; i < proves.size(); i++) {
            System.out.println(i+1 + ") " + proves.get(i).getNomProva());
        }
        System.out.println();
        System.out.println(i+1 + ") Back");
        return i+1;
    }

    public void mostraInformacioProva(int numProva){
        System.out.println("Trial: " + proves.get(numProva - 1).getNomProva() + " (Paper publication)");
        System.out.println("Journal: " + proves.get(numProva - 1).getNomRevista() + "(" + proves.get(numProva - 1).getQuartil() + ")");
        System.out.println("Chances: " + proves.get(numProva - 1).getProbabilitatArticle() + "% acceptance, " + proves.get(numProva - 1).getProbabilitatRevisio()
                            + "% revision, " + proves.get(numProva- 1).getProbabilitatRebuig() + " rejection");
    }

    public void eliminarProva(int numProva){
        System.out.println();
    }
}
