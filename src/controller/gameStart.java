
package controller;

import entity.stopWatch;
import java.util.Random;
import java.util.Scanner;
import adt.*;
import entity.Station;

/**
 *
 * @author Jaylim
 */
public class gameStart {
    ctrlMaintainQuestion questionCtrl = new ctrlMaintainQuestion();
    StationListInterface<Station> listStation = new StationList<>();
    stopWatch sw = new stopWatch();
    int diceNumber, diceFromUser, stationNum = 0, userAns, databaseAns;
    Scanner scan = new Scanner(System.in);
    String question;
    
    public int run(){
                
        System.out.println("======== The game will be begin now. ========");
        System.out.println("When the game begin, we will roll the dice to decide a question for you. ");
        pressAnyKeyToContinue();
        sw.start();
        
        while(listStation.getPlayerPosition() < listStation.getSize() - 1) {

            if(listStation.isPlayerAtStarting()) {
                diceNumber = rollDice();

                while(diceNumber < 0)
                    diceNumber = rollDice();

                System.out.println("The dice that system roll out is " + diceNumber + "." + " >> Proceed to " + listStation.getAtPosition(listStation.getPlayerPosition() + diceNumber).getStationName());

                listStation.updatePath(diceNumber);

                System.out.println();
            } else { 
                System.out.println("Current location in Race Path: ");
                listStation.display();
                System.out.println();
                if(mission()) {
                    pleaseRollDice();
                    pressAnyKeyToContinue();
                    diceNumber = rollDice();

                    while(diceNumber + listStation.getPlayerPosition() < 0)
                        diceNumber = rollDice();
                    
                    System.out.println(diceNumber + "   " + listStation.getPlayerPosition() + "     " + listStation.getSize()); // here is where the number comes from
                    
                    String nextStation;

                    if(listStation.getAtPosition(listStation.getPlayerPosition()+diceNumber) == null) {
                        nextStation = "Finishing Point";
                    } else {
                        nextStation = listStation.getAtPosition(listStation.getPlayerPosition() + diceNumber).getStationName();
                    }

                    System.out.println("The dice that system roll out is " + diceNumber + "." + " >> Proceed to " + nextStation);

                    if(!nextStation.equals("Finishing Point")) {
                        listStation.updatePath(diceNumber);
                        
                    } else
                        break;
                    
                } else {
                    System.out.println("Incorrect Answer.. Please Try again.");
                }
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
   
    public static int rollQuestion() {

        Random rand = new Random();
        return rand.nextInt(20) +1;
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
    
    public boolean mission() { // here we do the mission and ask the user to answer it too.
       boolean correct = true;
       Station currStation = listStation.getAtPosition(listStation.getPlayerPosition());
       ctrlMaintainQuestion q = new ctrlMaintainQuestion();
       int quesNo = rollQuestion();

       System.out.println(currStation.getStationName() + " Mission: " + currStation.getStationDescription());
       
       System.out.println(q.getQuestion(quesNo));
       System.out.print(q.getSelection1(quesNo) + "\n" + q.getSelection2(quesNo) + "\n" + q.getSelection3(quesNo) + "\n" + q.getSelection4(quesNo) + "\n");
       System.out.print("Answer: ");
       if(!(scan.nextLine().equals(q.getAnswer(quesNo)))) {
           correct = false;
       }
       return correct;
   }
    
    private void pleaseRollDice(){
        System.out.println(" To roll the dice... ");
    }
}
