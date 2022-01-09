package Presentation;


import Business.Player;


import java.util.ArrayList;
import java.util.Calendar;

import java.util.Scanner;

/**
 * Classe on mostrem tots els menus del programa
 * Authors: Joan Llobet i Lluis Gumbau
 */
public class Menu {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Menú principal del programa, on tries el teu rol
     * @return Retornem l'opció escollida per l'usuari
     */
    public String menuPrincipal(){
        String opcio;
        boolean error = false;
        System.out.println("\n" +
                "     _____ _            _____      _       _     \n" +
                "    /__    |\\__   ___  /__   \\_ __(_) __ _| |___ \n" +
                "      / /\\/ '_ \\ / _ \\   / /\\/ '__| |/ _` | / __|\n" +
                "     / /  | | | |  __/  / /  | |  | | (_| | \\__ \\\n" +
                "     \\/   |_| |_|\\___|  \\/   |_|  |_|\\__,_|_|___/");
        System.out.println();
        do{
            error = false;
            System.out.println();
            System.out.println("Welcome to The Trials. Who are you?");
            System.out.println();
            System.out.println("\tA) The Composer");
            System.out.println("\tB) This year's Conductor");
            System.out.println();
            System.out.print("Enter a role: ");
            opcio = scanner.nextLine();
            if (!opcio.equals("A") && !opcio.equals("B")){
                System.out.println("Incorrect option, please choose a correct one!");
                error = true;
            }
        }while (error);
        return opcio;
    }

    /**
     * Menú principal si el rol escollit ha esta "A" Compositor
     * @return Retornem l'opció escollida i la passem a enter.
     */
    public int menuCompositor(){
        String option;
        boolean error = false;

        do{
            error = false;
            System.out.println();
            System.out.println("Entering management mode...");
            System.out.println();
            System.out.println("\t1) Manage Trials");
            System.out.println("\t2) Manage Editions");
            System.out.println();
            System.out.println("\t3) Exit");
            System.out.println();
            System.out.print("Enter an option: ");
            option = scanner.nextLine();
                if (option.equals("1") || option.equals("2") || option.equals("3")){
                    return Integer.parseInt(option);
                } else{
                    System.out.println("Incorrect option, please choose a correct one!");
                    error = true;
                }
        }while (error);
        return Integer.parseInt(option);
    }

    /**
     * Menú on podem gestionar les proves
     * @return L'opció escollida per l'usuari
     */
    public String manageTrial(){
        String opcio;
        boolean error = false;
        do {
            error = false;
            System.out.println();
            System.out.println("\ta) Create Trial");
            System.out.println("\tb) List Trials");
            System.out.println("\tc) Delete Trial");
            System.out.println();
            System.out.println("\td) Back");
            System.out.println();
            System.out.print("Enter an option: ");
            opcio = scanner.nextLine();
                if(opcio.equals("a") || opcio.equals("b") || opcio.equals("c") || opcio.equals("d")){
                    return opcio;
                }else{
                    System.out.println("Incorrect option, please choose a correct one!");
                    error = true;
                }
        }while (error);
        return null;
    }

    /**
     * Menú per crear una prova
     * @return Retornem l'opcio que ha triat l'usuari, en aquest cas sempre serà un 1
     */
    public int menuTrialCreation(){
        String opcio;
        boolean error = false;
        do {
            //error = false;
            System.out.println();
            System.out.println("\t--- Trail types ---");
            System.out.println();
            System.out.println("\t1) Paper publication");
            System.out.println();
            System.out.print("Enter the trial's type: ");
            opcio = scanner.nextLine();
            if(opcio.equals("1")){
                return Integer.parseInt(opcio);
            }else{
                System.out.println("Incorrect option, please choose a correct one!");
                error = true;
            }
        }while (error);
        return Integer.parseInt(opcio);
    }

    /**
     * Capçalera de l'opcio de llistar les proves
     */
    public void menuTrialsList(){
        boolean error = false;
        do{
            System.out.println();
            System.out.println("Here are the current trials, do you want to see more details or go back?");
            System.out.println();
        }while (error);
    }

    /**
     * En els menus on primer mostrem una llista amb les opcins, invoquem aquest mètode, on ens controla que introduim una opcio correcte
     * @param opcio numero d'opcions que hi ha
     * @return Opció entrada per l'usuari
     */
    public int enterOption(int opcio){
        boolean error;
        String option;
        do {
            error = false;
            System.out.println();
            System.out.print("Enter an option: ");
            option = scanner.nextLine();
            try {
                Integer.parseInt(option);
                if (Integer.parseInt(option) < 1 || Integer.parseInt(option) > opcio){
                    System.out.println("Incorrect option, enter a number between 1 and " + opcio);
                    error = true;
                }
                if (Integer.parseInt(option) == opcio){
                    return Integer.parseInt(option);
                }
            }catch (NumberFormatException e){
                System.out.println("Incorrect option, enter a number between 1 and " + opcio);
                error = true;
            }
        }while (error);
        return Integer.parseInt(option);
    }

    /**
     * Capçalera del menu per eliminar una prova
     */
    public void eliminacioProvaMenu(){
        System.out.println();
        System.out.println("Which trial do you want to delete?");
        System.out.println();
    }

    /**
     * Mètode que demana al usuari la confirmacio per eliminar la prova seleccionada
     * @return el nom que entra l'usuari.
     */
    public String confirmacioEliminacio(){
        System.out.print("Enter the trial's name for confirmation: ");
        String nomProva = llegirString();

        return nomProva;
    }

    /**
     * Submenu principal de gestió de les edicions
     * @return l'opcio triada per l'usuari
     */
    public String manageEditions(){
        String opcio;
        boolean error;
        do {
            error = false;
            System.out.println();
            System.out.println("\ta) Create Edition");
            System.out.println("\tb) List Editions");
            System.out.println("\tc) Duplicate Edition");
            System.out.println("\td) Delete Edition");
            System.out.println();
            System.out.println("\te) Back");
            System.out.println();
            System.out.print("Enter an option: ");
            opcio = scanner.nextLine();
            if(opcio.equals("a") || opcio.equals("b") || opcio.equals("c") || opcio.equals("d") || opcio.equals("e")){
                return opcio;
            }else {
                System.out.println("Incorrect option, please choose a correct one!");
                error = true;
            }
        }while (error);
        return opcio;
    }


    /**
     * Mètode que mostra el missatge de shutting down depenent l'opció triada
     */
    public void shuttingDown(){
        System.out.println();
        System.out.println("Shutting down...");
    }

    /**
     * Mètode per entrar string. A més a més, comprova que no estigui buida
     * @return el contingut de la string
     */
    public String llegirString(){
        boolean buit = false;
        String string;
            string = scanner.nextLine();
            if (!string.isEmpty()){

            }else{
                buit = true;
                System.out.println("Please enter a correct value!");
            }
        return string;
    }

    /**
     * Mètode on demanem i comprovem les probabilitats
     * @return probabilitats entrades per l'usuari
     */
    public int demanarProbabilitats(){
        boolean error = false;
            String string = scanner.nextLine();
        int num = 0;
        try{
            num = Integer.parseInt(string);
            if (num < 0 || num > 100){
                System.out.println("Please enter a number between 0 and 100!");
                error = true;
            }
                
        }catch (NumberFormatException e){
            System.out.println("Please enter a number between 0 and 100!");
            error = true;
        }
        return num;
    }

    /**
     * Mètode on demanem i comprvem l'any de l'edició
     * @return l'any seleccionat per l'usuari
     */
    public int demanarAnyEdicio(){
        boolean error;
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        do{
            error = false;
            System.out.println();
            System.out.print("Enter the edition's year: ");
            String anyEdicio = scanner.nextLine();
            try {
                Integer.parseInt(anyEdicio);
                if (Integer.parseInt(anyEdicio) >= actualYear){
                    return Integer.parseInt(anyEdicio);
                }else {
                    System.out.println("Error: Edition year must be greater than the current one (" + actualYear + ")!!");
                    error = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Incorrect value, your edition's year have to be a number");
                error = true;
            }
        }while (error);
        return 0;
    }

    /**
     * Mètode per demanar i controlar el nombre de jugadors per edició
     * @return el numero de jugadors
     */
    public int demanarNumPlayersEdicio(){
        boolean error;
        do{
            error = false;
            System.out.print("Enter the initial number of players: ");
            String numJugadors = scanner.nextLine();
            try {
                Integer.parseInt(numJugadors);
                if (Integer.parseInt(numJugadors) > 0 && Integer.parseInt(numJugadors) < 6) {
                    return Integer.parseInt(numJugadors);
                }else {
                    System.out.println("Error: The number of players has to be between 1 and 5!");
                    error = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Incorrect value, your edition's year have to be a number");
                error = true;
            }
        }while(error);
        return 0;
    }

    /**
     * Mètode per demanar i controlar el numero de proves que hi ha per edició
     * @return el numero de proves que volem afegir
     */
    public int demanarNumProves(){
        boolean error;
        do {
            error = false;
            System.out.print("Enter the number of trials: ");
            String numProves = scanner.nextLine();
            try {
                Integer.parseInt(numProves);
                if (Integer.parseInt(numProves) > 2 && Integer.parseInt(numProves) < 13) {
                    return Integer.parseInt(numProves);
                }else {
                    System.out.println("Error: The number of players has to be between 1 and 5!");
                    error = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Incorrect value, your edition's year have to be a number");
                error = true;
            }
        }while (error);
        return 0;
    }

    /**
     * Mètode on escollim la prova per les edicions.
     * @param numProves Proves seleccionades per l'usuari, és a dir les proves que afegim per l'edicio
     * @param i Index, posició del for del controller
     * @param numeroProvesFitxer El numero total de proves que hi ha en el csv/llista
     * @return El numero de prova seleccionat, més tard el tractarem com la posició de la llista proves.
     */
    public int pickTrials(int numProves, int i, int numeroProvesFitxer){
        boolean error;
            do {
                error = false;
                System.out.print("Pick a trial (" + i + "/" + numProves + "): ");
                String selectedTrial = scanner.nextLine();
                try {
                    Integer.parseInt(selectedTrial);
                    if (Integer.parseInt(selectedTrial) >= 1 && Integer.parseInt(selectedTrial) < numeroProvesFitxer){
                        return Integer.parseInt(selectedTrial);
                    }else{
                        System.out.println("Error: Select an option between 1 and " + numeroProvesFitxer + "!!");
                        error = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect value, your edition's year have to be a number");
                    error = true;
                }
            }while (error);
        return 0;
    }

    /**
     * Capçalera opcio b menu edicions
     */
    public void menuMostraEdicions(){
        System.out.println();
        System.out.println("Here are the current editions, do you want to see more details or go back?");
        System.out.println();
    }

    /**
     * Capçalera opcio c menu edicions
     */
    public void menuDuplicarEdicio(){
        System.out.println();
        System.out.println("Which edition do you want to clone?");
        System.out.println();
    }

    /**
     * Mètode que guarda i comprova el nou any de l'edicio
     * @return retorna l'any que ha seleccionat l'usuari
     */
    public int duplicarEdicioAny(){
        boolean error;
        do {
            error = false;
            System.out.println();
            System.out.print("Enter the new edition's year: ");
            String any = scanner.nextLine();
            try {
                return Integer.parseInt(any);
            }catch (NumberFormatException e){
                System.out.println("Incorrect value, your edition's year have to be a number");
                error = true;
            }
        }while (error);
        return 0;
    }

    /**
     * Mètode que guarda i comprova el nou nombre de jugadors de l'edicio
     * @return el nou numero de jugadors per aquesta nova edicio
     */
    public int duplicarEdicioPlayers(){
        boolean error;
        do {
            error = false;
            System.out.print("Enter the new edition's initial number of players: ");
            String numPLayers = scanner.nextLine();
            try {
                Integer.parseInt(numPLayers);
                if (Integer.parseInt(numPLayers) > 0 && Integer.parseInt(numPLayers) < 6) {
                    return Integer.parseInt(numPLayers);
                }else {
                    System.out.println("Error: The number of players has to be between 1 and 5!");
                    error = true;
                }
            }catch (NumberFormatException e){
                System.out.println("Incorrect value, your edition's year have to be a number");
                error = true;
            }
        }while (error);
        return 0;
    }

    /**
     * Capçalera de opció eliminar edició
     */
    public void menuEliminarEdicio(){
        System.out.println();
        System.out.println("Which edition do you want to delete? ");
        System.out.println();
    }

    /**
     * Mètode on comprovem que l'any de confirmació és correcte
     * @return l'any de confirmació
     */
    public int enterYearConfirmation(){
        boolean error;
        do {
            error = false;
            System.out.println();
            System.out.print("Enter the edition year for confirmation: ");
            String anyEdicio = scanner.nextLine();
            try {
                System.out.println(Integer.parseInt(anyEdicio));
                return Integer.parseInt(anyEdicio);
            }catch (NumberFormatException e){
                System.out.println("Incorrect value, your edition's year have to be a number");
                error = true;
            }
        }while (error);
        return 0;
    }

    public void executaConductor(){
        System.out.println();
        System.out.println("Entering execution mode...");
    }
    public void noEdition(int currentyear){
        System.out.println();
        System.out.println("No edition is defined for the current year (" + currentyear +").");
        System.out.println();
        System.out.println("Shutting down...");
    }
    public ArrayList<Player> askPlayers(int playerCount, int currentYear){
        ArrayList<Player> players = new ArrayList<>();
        Player playertmp = new Player();

        System.out.println("--- The Trials "+ currentYear + " ---");
        System.out.println();
        for(int i = 1; i<= playerCount; i++){
            System.out.println("Enter the player's name (" + i + "/" + playerCount + "): ");
            playertmp.setName(scanner.nextLine());
            playertmp.setPI(5);
            players.add(playertmp);

        }
        return players;
    }

    public void trialStart(int trialnum, String nomProva){
        System.out.println("Trial #"+trialnum+ " - " + nomProva );
    }

}
