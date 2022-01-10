package Business;

public class Prova {
    private String nomProva;
    private String nomRevista;
    private String quartil;
    private float probabilitatArticle;
    private float probabilitatRevisio;
    private float probabilitatRebuig;

    public Prova(String nomProva, String nomRevista, String quartil, float probabilitatArticle, float probabilitatRevisio, float probabilitatRebuig) {
        this.nomProva = nomProva;
        this.nomRevista = nomRevista;
        this.quartil = quartil;
        this.probabilitatArticle = probabilitatArticle;
        this.probabilitatRevisio = probabilitatRevisio;
        this.probabilitatRebuig = probabilitatRebuig;
    }

    public String getNomProva() {
        return nomProva;
    }

    public String getNomRevista() {
        return nomRevista;
    }

    public String getQuartil() {
        return quartil;
    }

    public float getProbabilitatArticle() {
        return probabilitatArticle;
    }

    public float getProbabilitatRevisio() {
        return probabilitatRevisio;
    }

    public float getProbabilitatRebuig() {
        return probabilitatRebuig;
    }

    public int getQuartilNum(String quartil){

        int quartilnum = quartil.charAt(1) - '0';
        return quartilnum;
    }


}
