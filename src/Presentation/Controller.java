package Presentation;

import Business.Prova;
import Persistance.ProvaCSV;

/**
 * Classe controler. Controlem tots la lògica dels menus del programa.
 * Authors: Joan Llobet i Lluís Gumbau.
 */
public class Controller {
    private Menu menu = new Menu();

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
                menu.manageEditions();
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
        ProvaCSV provaCSV = new ProvaCSV();
        switch (opcioManage){
            case "a":
                menu.menuTrialCreation();
                break;
            case "b":
                break;
            case "c":
                break;
            case "d":
                int opcio = 0;
                opcio = menu.menuCompositor();
                gestioMenuCompositor(opcio);
                break;
        }
    }
}
