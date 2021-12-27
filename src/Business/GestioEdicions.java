package Business;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestioEdicions {
    private Scanner scanner = new Scanner(System.in);

    public void creaEdicio(){
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        int year = 0;

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



    }
}
