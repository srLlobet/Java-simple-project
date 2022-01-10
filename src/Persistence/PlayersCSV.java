package Persistence;

import Business.Player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PlayersCSV {
    String[] infoLinia;


    public ArrayList<Player> llegirDades(int playercount, ArrayList<Player> players){

        String informacio;
        FileReader fileReader = null;
        try{
            fileReader = new FileReader("assets/players.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try{
            informacio = bufferedReader.readLine();
            this.infoLinia = informacio.split(",");

            //primer nom
            for (int i = 1; i < (playercount*2); i = i+2){
                    Player playertmp = new Player();
                    playertmp.setName(infoLinia[i]);
                    playertmp.setPI(Integer.parseInt(infoLinia[i+1]));
                    players.add(playertmp);
                }
                    int stringorint = 0;
                    if(stringorint == 0){

                    }
                } catch (IOException e) {
            e.printStackTrace();
        }

        return players;
    }

    public Integer llegirProva() {
        return Integer.parseInt(this.infoLinia[0]);
    }

}
