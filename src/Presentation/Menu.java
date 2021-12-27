package Presentation;

import Business.FitxerProva;
import Business.Prova;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
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
     * Capçelera de l'opcio de llistar les proves
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

    public void eliminacioProvaMenu(){
        System.out.println();
        System.out.println("Which trial do you want to delete?");
        System.out.println();
    }

    public String confirmacioEliminacio(){
        System.out.print("Enter the trial's name for confirmation: ");
        String nomProva = llegirString();

        return nomProva;
    }

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
                error = false;
            }else {
                System.out.println("Incorrect option, please choose a correct one!");
            }
        } while (error);
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
     * @return
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



}
