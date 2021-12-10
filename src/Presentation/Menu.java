package Presentation;

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
        String option = null;
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
        return 0;
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

    public void menuTrialCreation(){
        String opcio;
        boolean error = false;
        do {
            System.out.println();
            System.out.println("\t--- Trail types ---");
            System.out.println();
            System.out.println("\t1) Paper publication");
            System.out.println();
            System.out.print("Enter the trial's type: ");
            opcio = scanner.nextLine();
            if(opcio.equals("1")){

            }else{
                System.out.println("Incorrect option, please choose a correct one!");
                error = true;
            }
        }while (error);
    }

    public void menuTrialsList(){
        System.out.println();
        System.out.println("Here are the current trials, do you want to see more details or go back?");
        System.out.println();
    }

    public void manageEditions(){
        System.out.println();
        System.out.println("\ta) Create Edition");
        System.out.println("\tb) List Editions");
        System.out.println("\tc) Duplicate Edition");
        System.out.println("\td) Delete Edition");
        System.out.println();
        System.out.println("\te) Back");
        System.out.println();
        System.out.print("Enter an option: ");
    }

    /**
     * Mètode que mostra el missatge de shutting down depenent l'opció triada
     */
    public void shuttingDown(){
        System.out.println();
        System.out.println("Shutting down...");
    }

}
