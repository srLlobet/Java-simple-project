package Persistence;

import Business.Prova;

import java.io.*;
import java.util.ArrayList;

public class ProvaCSV {
    ArrayList<Prova> proves = new ArrayList<Prova>();

    public ArrayList<Prova> llegirDades(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("assets/proves.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String informacio = null;
        try {
            informacio = bufferedReader.readLine();
            String[] infoLinia1 = informacio.split(",");
            proves.add(new Prova(infoLinia1[0], infoLinia1[1], infoLinia1[2], Float.parseFloat(infoLinia1[3]), Float.parseFloat(infoLinia1[4]), Float.parseFloat(infoLinia1[5])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (informacio != null){
            try {
                informacio = bufferedReader.readLine();
                if (informacio != null){
                    String[] infoLinia = informacio.split(",");
                    proves.add(new Prova(infoLinia[0], infoLinia[1], infoLinia[2], Float.parseFloat(infoLinia[3]), Float.parseFloat(infoLinia[4]), Float.parseFloat(infoLinia[5])));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return proves;
    }

    public void addProva(String nomProva, String nomRevista, String quatille, int accProb, int revProb, int rejProb){
        File fileCSV = new File("assets/proves.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileCSV, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder liniaCSV = new StringBuilder();
        liniaCSV.append(nomProva);
        liniaCSV.append(",");
        liniaCSV.append(nomRevista);
        liniaCSV.append(",");
        liniaCSV.append(quatille);
        liniaCSV.append(",");
        liniaCSV.append(accProb);
        liniaCSV.append(",");
        liniaCSV.append(revProb);
        liniaCSV.append(",");
        liniaCSV.append(rejProb);
        liniaCSV.append("\n");
        try {
            fileWriter.write(String.valueOf(liniaCSV));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("We can't save your information in our file!");
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
