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

    public void setNomProva(String nomProva) {
        this.nomProva = nomProva;
    }

    public String getNomRevista() {
        return nomRevista;
    }

    public void setNomRevista(String nomRevista) {
        this.nomRevista = nomRevista;
    }

    public String getQuartil() {
        return quartil;
    }

    public void setQuartil(String quartil) {
        this.quartil = quartil;
    }

    public float getProbabilitatArticle() {
        return probabilitatArticle;
    }

    public void setProbabilitatArticle(float probabilitatArticle) {
        this.probabilitatArticle = probabilitatArticle;
    }

    public float getProbabilitatRevisio() {
        return probabilitatRevisio;
    }

    public void setProbabilitatRevisio(float probabilitatRevisio) {
        this.probabilitatRevisio = probabilitatRevisio;
    }

    public float getProbabilitatRebuig() {
        return probabilitatRebuig;
    }

    public void setProbabilitatRebuig(float probabilitatRebuig) {
        this.probabilitatRebuig = probabilitatRebuig;
    }
}
