package Business;

import java.util.ArrayList;

public class Edicio {
    private Integer year;
    private Integer playerCount;
    private Integer trialCount;
    private ArrayList<Prova> trials;


    public Edicio(Integer year, Integer playerCount, Integer trialCount) {
        this.year = year;
        this.playerCount = playerCount;
        this.trialCount = trialCount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(Integer playerCount) {
        this.playerCount = playerCount;
    }

    public Integer getTrialCount() {
        return trialCount;
    }

    public void setTrialCount(Integer trialCount) {
        this.trialCount = trialCount;
    }

    public ArrayList<Prova> getTrials() {
        return trials;
    }

    public void setTrials(ArrayList<Prova> trials) {
        this.trials = trials;
    }
}
