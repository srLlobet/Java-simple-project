package Persistence;

import Business.Edicio;
import Business.Prova;

import java.io.*;
import java.util.ArrayList;

public class EdicioCSV {
    ArrayList<Edicio> edicions = new ArrayList<Edicio>();

    /**
     *Llegim les dades del fitxer csv i afegim el contingut a la llista d'edicions
     *@return La llista amb les edicions
     */
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
            ArrayList<String> nomProves = new ArrayList<String>();
            for (int i = 0; i < Integer.parseInt(infoLinia1[2]); i++) {
                nomProves.add(infoLinia1[i + 3]);
            }
            edicions.add(new Edicio(Integer.parseInt(infoLinia1[0]), Integer.parseInt(infoLinia1[1]), Integer.parseInt(infoLinia1[2]), nomProves));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (informacio != null){
            try {
                informacio = bufferedReader.readLine();
                if (informacio != null){
                    String[] infoLinia = informacio.split(",");
                    ArrayList<String> nomProves = new ArrayList<String>();
                    for (int i = 0; i < Integer.parseInt(infoLinia[2]); i++) {
                        nomProves.add(infoLinia[i + 3]);
                    }
                    edicions.add(new Edicio(Integer.parseInt(infoLinia[0]), Integer.parseInt(infoLinia[1]), Integer.parseInt(infoLinia[2]), nomProves));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return edicions;
    }

    /**
     * Afegim l'edicio separada per comes en el csv
     * @param anyEdicio Any de l'edicio
     * @param nombreJugadors Nombre de participant de l'edicio
     * @param nombreProves Numero de proves
     * @param llistaProves Nom de les proves totals
     */
    public void addEdicio(int anyEdicio, int nombreJugadors, int nombreProves, ArrayList<String> llistaProves){
        File fileCSV = new File("assets/edicions.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileCSV, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder liniaCSV = new StringBuilder();
        liniaCSV.append(anyEdicio);
        liniaCSV.append(",");
        liniaCSV.append(nombreJugadors);
        liniaCSV.append(",");
        liniaCSV.append(nombreProves);
        liniaCSV.append(",");
        for (int i = 0; i < llistaProves.size(); i++) {
            if (i == llistaProves.size() - 1){
                liniaCSV.append(llistaProves.get(i));
                liniaCSV.append("\n");
            }else {
                liniaCSV.append(llistaProves.get(i));
                liniaCSV.append(",");
            }
        }

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

    /**
     * Reescriure el fitxer i la llista, així quan borrem una prova tornem a omplir el csv i la llista
     */
    public void reescriureDades(){
        File fileCSV = new File("assets/edicions.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileCSV);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder liniaCSV = new StringBuilder();
        for (Edicio edicio : edicions) {
            liniaCSV.append(edicio.getAnyEdicio());
            liniaCSV.append(",");
            liniaCSV.append(edicio.getNombreJugadors());
            liniaCSV.append(",");
            liniaCSV.append(edicio.getNombreProves());
            liniaCSV.append(",");
            for (int i = 0; i < edicio.getNombreProves(); i++) {
                if (i == edicio.getNombreProves() - 1){
                    liniaCSV.append(edicio.getLlistaProves().get(i));
                    liniaCSV.append("\n");
                }else {
                    liniaCSV.append(edicio.getLlistaProves().get(i));
                    liniaCSV.append(",");
                }
            }
        }

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
