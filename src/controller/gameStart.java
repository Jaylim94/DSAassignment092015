
package controller;

import java.util.Random;

/**
 *
 * @author Jaylim
 */
public class gameStart {
    ctrlMaintainQuestion questionCtrl = new ctrlMaintainQuestion();
    int diceNumber, stationNum;
    String question;
    
    public void run(){
        System.out.println("======== The game will be begin now. ========");
        System.out.println("When the game begin, we will roll the dice to decide a question for you. ");
        pressAnyKeyToContinue();
        
        diceNumber = rollDice();
        System.out.println("The dice that system roll out is " + diceNumber + ".");
        
        if (stationNum >1 ){
            
        }else if(stationNum == 0){
            System.out.println("THIS IS STARTING POINT");
            question = questionCtrl.getQuestion(diceNumber + 2);
            System.out.println("Your question : " + question);
            // I end here 25112015 14.15
        }
        
        
    }
    
    public static int rollDice() {

        Random rand = new Random();
        int randomNum;

        do{
            randomNum = rand.nextInt(6) -2 ;
        }while (randomNum == 0);

        return randomNum;
    }
    
    
    private void pressAnyKeyToContinue()
 { 
        System.out.println("Press any key to roll the dice...");
        try
        {
            System.in.read();
        }  
        catch(Exception e){
         System.out.println(e.getMessage());
        }  
 }
}
