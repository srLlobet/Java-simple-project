package Business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GestioProva {
    private Random random = new Random();


    public ArrayList<Player> executaProves(Prova prova, ArrayList<Player> players){
        for(Player i : players){
            System.out.println(i.getName() + " is submitting...");
            treuchances(prova, i);
        }
        removePlayers(players);
        return players;
    }

    public void treuchances(Prova prova, Player player){
        int num = random.nextInt(100);
        if(((float)num) <= prova.getProbabilitatArticle()){
            accept(player, prova.getQuartilNum(prova.getQuartil()));
        }else{
            if(((float)num) <= (prova.getProbabilitatRevisio() + prova.getProbabilitatArticle())){
                System.out.println("Revisions...");
                treuchances(prova, player);
            } else {
                reject(player, prova.getQuartilNum(prova.getQuartil()));
            }
        }
    }

    public void accept(Player player, int quartilNum){
        switch (quartilNum){
            case 1:
                player.setPI(player.getPI() + 4);
                break;
            case 2:
                player.setPI(player.getPI() + 3);
                break;
            case 3:
                player.setPI(player.getPI() + 2);
                break;
            case 4:
                player.setPI(player.getPI() + 1);
                break;
        }
        System.out.println("Accepted! PI count: " + player.getPI());
        System.out.println();
    }

    public void reject(Player player, int quartilNum){
        switch (quartilNum){
            case 1:
                player.setPI(player.getPI() - 5);
                break;
            case 2:
                player.setPI(player.getPI() - 4);
                break;
            case 3:
                player.setPI(player.getPI() - 3);
                break;
            case 4:
                player.setPI(player.getPI() - 2);
                break;
        }
        if(player.getPI() <= 0){
            System.out.println("Rejected. PI count: " + player.getPI() + " Disqualified!");
            System.out.println();
        } else {
            System.out.println("Rejected. PI count: " + player.getPI());
            System.out.println();
        }
    }
    public void removePlayers(ArrayList<Player> players){
        Iterator<Player> i = players.iterator();
        while (i.hasNext()){
            Player x = i.next();
            if(x.getPI() <= 0){
                i.remove();
            }
        }

    }

}
