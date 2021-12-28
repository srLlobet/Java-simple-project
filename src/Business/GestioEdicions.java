package Business;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioEdicions {
    private Scanner scanner = new Scanner(System.in);

    public void creaEdicio(){
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        FitxerProva proves = new FitxerProva();
        int year = 0;
        int playercount = 0;
        int trialcount = 0;

            System.out.println("Enter the edition's year: ");

            try{
                year = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Please enter a correct value!");
                return;
            }
            if(year < currentyear ){
                System.out.println("Please enter a valid year");
                return;
            }


        System.out.println("Enter the initial number of players: ");
            try{
                playercount = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter a correct value!");
                return;
            }
            if(playercount < 1 || playercount > 5){
                System.out.println("Please enter a valid number of players [1,5]");
                return;
            }

        System.out.println("Enter the number of trials: ");
            try{
                trialcount = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter a correct value!");
                return;
            }
            if(trialcount <3 || trialcount > 12){
                System.out.println("Please enter a valid number of trials [3,12] ");
            } else {
                System.out.println("\t--- Trials ---\n");
                proves.mostrarTotesProves();
            }




    }
}
