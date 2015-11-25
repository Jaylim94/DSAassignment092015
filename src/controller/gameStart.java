
package controller;

import java.util.Random;
import java.util.Scanner;
import adt.*;

/**
 *
 * @author Jaylim
 */
public class gameStart {
    ctrlMaintainQuestion questionCtrl = new ctrlMaintainQuestion();
    stopWatch sw = new stopWatch();
    int diceNumber, diceFromUser, stationNum = 0, userAns, databaseAns;
    Scanner scan;
    String question;
    
    public int run(){
                
        System.out.println("======== The game will be begin now. ========");
        System.out.println("When the game begin, we will roll the dice to decide a question for you. ");
        pressAnyKeyToContinue();
        sw.start();
        diceNumber = rollDice();
        System.out.println("The dice that system roll out is " + diceNumber + ".");
        
        while(stationNum != 7){
            
            if (stationNum >1 ){
                System.out.println("THIS IS STATION " + stationNum + " .");
                pleaseRollDice(); 
                pressAnyKeyToContinue();
                diceFromUser = rollDice();
                question = questionCtrl.getQuestion(diceFromUser);
                do{
                    System.out.println("Your Answer : " + scan.nextInt(userAns));
                }while(userAns != databaseAns);
                stationNum++;

            }else if(stationNum == 0){
                System.out.println("THIS IS STARTING POINT");
                diceFromUser = diceNumber + 2; //starting point not to let user get negative moves.
                question = questionCtrl.getQuestion(diceFromUser);
                databaseAns = questionCtrl.getAnswer(diceFromUser);
                System.out.println("Your question : " + question);
                do{
                    System.out.println("Your Answer : " + scan.nextInt(userAns));
                }while(userAns != databaseAns);

                stationNum++;
            }
        }
        sw.end();
        System.out.println(" ----------- Congratulation, you have finish the game !! -----------");
        System.out.println(sw.toString());
        return sw.timeSpend();
    }
    
    public static int rollDice() {

        Random rand = new Random();
        int randomNum;

        do{
            randomNum = rand.nextInt(6) -2 ;
        }while (randomNum == 0);

        return randomNum;
    }
    
    
    private void pressAnyKeyToContinue(){ 
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e){
         System.out.println(e.getMessage());
        }  
    }
    
    private void pleaseRollDice(){
        System.out.println(" To roll the dice... ");
    }
}
