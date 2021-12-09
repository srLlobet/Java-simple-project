package Presentation;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void menuPrincipal(){

        System.out.println("\n" +
                "     _____ _            _____      _       _     \n" +
                "    /__    |\\__   ___  /__   \\_ __(_) __ _| |___ \n" +
                "      / /\\/ '_ \\ / _ \\   / /\\/ '__| |/ _` | / __|\n" +
                "     / /  | | | |  __/  / /  | |  | | (_| | \\__ \\\n" +
                "     \\/   |_| |_|\\___|  \\/   |_|  |_|\\__,_|_|___/");
        System.out.println();
        System.out.println();
        System.out.println("Welcome to The Trials. Who are you?");
        System.out.println();
        System.out.println("\tA) The Composer");
        System.out.println("\tB) This year's Conductor");
        System.out.println();
        System.out.println("Enter a role:");

    }

    public void menuCompositor(){
        System.out.println();
        System.out.println("Entering management mode...");
        System.out.println();
        System.out.println("\t1) Manage Trials");
        System.out.println("\t2) Manage Editions");
        System.out.println();
        System.out.println("3) Exit");
        System.out.println();
        System.out.println("Enter an option: ");

    }

    public void manageTrial(){
        System.out.println();
        System.out.println("\ta) Create  Trial");
        System.out.println("\tb) List Trials");
        System.out.println("\tc) Delete Trial");
        System.out.println();
        System.out.println("\td) Back");
        System.out.println();
        System.out.println("Enter an option: ");
    }

    public void menuTrialCreation(){
        System.out.println();
        System.out.println("\t--- Trail types ---");
        System.out.println();
        System.out.println("\t1) Paper publication");
        System.out.println();
        System.out.println("Enter the trial's type: ");
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
        System.out.println("Enter an option: ");
    }
}
