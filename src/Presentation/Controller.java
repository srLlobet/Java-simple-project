package Presentation;

import Business.FitxerEdicio;
import Business.FitxerProva;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Classe controler. Controlem tots la lògica dels menus del programa.
 * Authors: Joan Llobet i Lluís Gumbau.
 */
public class Controller {
    private Menu menu;
    private FitxerProva fitxerProva;
    private FitxerEdicio fitxerEdicio;

    public Controller(Menu menu, FitxerProva fitxerProva, FitxerEdicio fitxerEdicio) {
        this.menu = menu;
        this.fitxerProva = fitxerProva;
        this.fitxerEdicio = fitxerEdicio;
    }

    /**
     * Mètode que s'encarrega d'executar els menus, en aquest cas el que gestiona depenent el rol principal que tries
     */
    public void iniciProves(){
        String selectedOtion = menu.menuPrincipal();

        switch (selectedOtion){
            case "A":
                int opcio = menu.menuCompositor();
                gestioMenuCompositor(opcio);
                break;

            case "B":
                menu.executaConductor();
                gestioMenuConductor();
                break;
        }
    }

    /**
     * Gestió del menu principal en el cas que hagis escollit compositor com a rol principal
     * @param opcio Li passem per referència l'opció seleccionada per l'usuari
     */
    public void gestioMenuCompositor(int opcio){
        switch (opcio){
            case 1:
                String opcioManage = menu.manageTrial();
                gestioSubmenuProves(opcioManage);
                break;
            case 2:
                String opcioEdicio = menu.manageEditions();
                gestioSubmenuEdicions(opcioEdicio);
                break;
            case 3:
                menu.shuttingDown();
                break;
        }
    }

    /**
     * Mètode que gestiona el menú de Manage Trials
     * @param opcioManage Li passem per referència l'opcio seleccionada per l'usuari
     */
    public void gestioSubmenuProves(String opcioManage){
        switch (opcioManage){
            /**
             * Menú creació de proves
             */
            case "a":
                int opcioA = menu.menuTrialCreation();
                if(opcioA == 1){
                    System.out.println();
                    String nomProva;
                    String nomRevista;
                    String quatille;
                    int accProb, revProb, rejProb;
                    boolean incorrect = false;
                    boolean provaExistent = false;
                    do{
                        System.out.print("Enter the trial's name: ");
                        nomProva = menu.llegirString();
                        provaExistent = fitxerProva.provaExistent(nomProva);
                    }while (nomProva.isEmpty() || provaExistent);
                    do{
                        System.out.print("Enter the journal's name: ");
                        nomRevista = menu.llegirString();
                    }while (nomRevista.isEmpty());

                    do{
                        incorrect = false;
                        System.out.print("Enter the journal's quartille: ");
                        quatille = menu.llegirString();
                        if (!quatille.equals("Q1") && !quatille.equals("Q2") && !quatille.equals("Q3") && !quatille.equals("Q4")){
                            System.out.println("Please enter a correct option (Q1, Q2, Q3, Q4)");
                            incorrect = true;
                        }
                    }while (incorrect);
                     do{
                         do {
                             System.out.print("Enter the acceptance probability: ");
                             accProb = menu.demanarProbabilitats();
                         }while (accProb < 0 || accProb > 100);
                         do {
                             System.out.print("Enter the revision probability: ");
                             revProb = menu.demanarProbabilitats();
                         }while (revProb < 0 || revProb > 100);
                         do {
                             System.out.print("Enter the rejection probability: ");
                             rejProb = menu.demanarProbabilitats();
                         }while (rejProb < 0 || rejProb > 100);
                         if (accProb + revProb + rejProb != 100){
                             System.out.println("The final sum of probabilities has to be 100!");
                         }
                     }while (accProb + revProb + rejProb != 100);

                    fitxerProva.afegirProva(nomProva, nomRevista, quatille, accProb, revProb, rejProb);
                    System.out.println("The trial was created successfully!");
                    gestioMenuCompositor(1);
                }
                break;

            case "b":
                /**
                 * Menú mostrar proves
                 */
                int opcioB;
                int mostraProva;
                boolean backB = false;
                    menu.menuTrialsList();
                    opcioB = fitxerProva.mostrarTotesProvesB();
                    mostraProva = menu.enterOption(opcioB);
                    if (mostraProva == opcioB){
                        gestioMenuCompositor(1);
                        backB = true;
                    }else {
                        fitxerProva.mostraInformacioProva(mostraProva);
                    }
                    if (!backB){
                        gestioMenuCompositor(1);
                    }
                break;

            /**
             * Menú seleccionar i eliminar prova
             */
            case "c":
                String nomEliminar;
                boolean found = false;
                boolean back = false;
                menu.eliminacioProvaMenu();
                int opcioC = fitxerProva.mostrarTotesProvesB();
                int eliminarProva = menu.enterOption(opcioC);
                if (eliminarProva == opcioC){
                    gestioMenuCompositor(1);
                    back = true;
                }
                if (!back){
                    do{
                        nomEliminar = menu.confirmacioEliminacio();
                        if(fitxerProva.eliminarProva(eliminarProva,nomEliminar)){
                            gestioMenuCompositor(1);
                            found = true;
                        }else{
                            found = false;
                        }
                    }while (!found);
                }

                break;

            /**
             * Opció de tornar al menú on triem controlar proves o edicions
             */
            case "d":
                int opcio;
                opcio = menu.menuCompositor();
                gestioMenuCompositor(opcio);
                break;
        }
    }

    /**
     * Mètode que gestiona el menú de Manage Editions
     * @param opcio Li passem per referència l'opcio seleccionada per l'usuari
     */
    public void gestioSubmenuEdicions(String opcio){
        switch (opcio){
            case "a":
                int numProvaArray;
                ArrayList<String> nomProves = new ArrayList<String>();
                int anyEdicio;
                boolean anyExistent;
                do {
                    anyEdicio = menu.demanarAnyEdicio();
                    anyExistent = fitxerEdicio.anyEdicioExistent(anyEdicio);
                }while (anyExistent);
                System.out.println("This edition year is already in use! Please enter a new one.");
                int numPlayers = menu.demanarNumPlayersEdicio();
                int numProves = menu.demanarNumProves();
                System.out.println("\t--- Trials ---");
                int numeroProvesFitxer = fitxerProva.mostrarTotesProves();
                for (int i = 0; i < numProves; i++) {
                    numProvaArray = menu.pickTrials(numProves, i+1, numeroProvesFitxer);
                    nomProves = fitxerProva.nomProvaPickTrial(numProvaArray, nomProves);
                }
                fitxerEdicio.afegirEdicio(anyEdicio, numPlayers, numProves, nomProves);
                System.out.println();
                System.out.println("The edition was created successfully!");
                gestioMenuCompositor(2);
                break;

            case  "b":
                    menu.menuMostraEdicions();
                    int opcions = fitxerEdicio.mostrarEdicionsB();
                    int provaSelected = menu.enterOption(opcions);
                    if (provaSelected == opcions){
                        gestioMenuCompositor(2);
                    }else {
                        fitxerEdicio.mostrarInformacioEdicio(provaSelected);
                        gestioMenuCompositor(2);
                    }
                break;

            case "c":
                    menu.menuDuplicarEdicio();
                    int options = fitxerEdicio.mostrarEdicionsB();
                    int edicioDuplicar = menu.enterOption(options);
                    if (edicioDuplicar == options){
                        gestioMenuCompositor(2);
                    }else{
                        boolean anyTrobat = false;
                        int nouAny;
                        do {
                            nouAny = menu.duplicarEdicioAny();
                            anyTrobat = fitxerEdicio.anyEdicioExistent(nouAny);
                        }while (anyTrobat);
                        int nouNumJug = menu.duplicarEdicioPlayers();
                        fitxerEdicio.duplicarEdicio(edicioDuplicar, nouAny, nouNumJug);
                        System.out.println();
                        System.out.println("The edition was cloned successfully!");
                        gestioMenuCompositor(2);
                    }
                break;

            case "d":
                    menu.menuEliminarEdicio();
                    int optionD = fitxerEdicio.mostrarEdicionsB();
                    int edicioEliminar = menu.enterOption(optionD);
                    if (edicioEliminar == optionD){
                        gestioMenuCompositor(2);
                    }else{
                        int anyVolemEliminar;
                        boolean buscarAny;
                        boolean trobatD;
                        do {
                            trobatD = false;
                            anyVolemEliminar = menu.enterYearConfirmation();
                            buscarAny = fitxerEdicio.buscarAnyEdicioConfirmar(edicioEliminar, anyVolemEliminar);
                            if (buscarAny){
                                fitxerEdicio.eliminarEdicio(edicioEliminar, anyVolemEliminar);
                                System.out.println("The edition was successfully deleted.");
                                gestioMenuCompositor(2);
                            }else{
                                System.out.println("The edition's years don't match! Please try again.");
                                trobatD = true;
                            }
                        }while (trobatD);

                    }
                break;

            case "e":
                int opcioE;
                opcioE = menu.menuCompositor();
                gestioMenuCompositor(opcioE);
                break;
        }
    }
    public void gestioMenuConductor(){
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        boolean exist = fitxerEdicio.anyEdicioExistent(currentyear);
        if(!exist){
            menu.noEdition(currentyear);
        }
    }

}
