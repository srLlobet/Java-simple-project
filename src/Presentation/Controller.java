package Presentation;

import Business.FitxerProva;
import Business.GestioEdicions;

/**
 * Classe controler. Controlem tots la lògica dels menus del programa.
 * Authors: Joan Llobet i Lluís Gumbau.
 */
public class Controller {
    private Menu menu;
    private FitxerProva fitxerProva;

    public Controller(Menu menu, FitxerProva fitxerProva) {
        this.menu = menu;
        this.fitxerProva = fitxerProva;
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
                //menuconductor
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
                    do{
                        System.out.print("Enter the trial's name: ");
                        nomProva = menu.llegirString();
                    }while (nomProva.isEmpty());
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
                    opcioB = fitxerProva.mostrarTotesProves();
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
                int opcioC = fitxerProva.mostrarTotesProves();
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
        GestioEdicions edicions = new GestioEdicions();
        switch (opcio){
            case "a":
                    edicions.creaEdicio();
                break;

            case  "b":
                break;

            case "c":
                break;

            case "d":
                break;

            case "e":
                int opcioE;
                opcioE = menu.menuCompositor();
                gestioMenuCompositor(opcioE);
                break;
        }
    }
}
