package Persistence;

import Business.Edicio;
import Business.Prova;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EdicionsCSV {
    ArrayList<Edicio> edicions = new ArrayList<>();


    public ArrayList<Edicio> llegirDades(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("assets/edicions.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String informacio = null;
        try {
            informacio = bufferedReader.readLine();
            String[] infoLinia1 = informacio.split(",");
            edicions.add(new Edicio(Integer.parseInt(infoLinia1[0]), Integer.parseInt(infoLinia1[1]), Integer.parseInt(infoLinia1[2])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (informacio != null){
            try {
                informacio = bufferedReader.readLine();
                if (informacio != null){
                    String[] infoLinia = informacio.split(",");
                    edicions.add(new Edicio(Integer.parseInt(infoLinia[0]), Integer.parseInt(infoLinia[1]), Integer.parseInt(infoLinia[2])));;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return edicions;
    }
}
