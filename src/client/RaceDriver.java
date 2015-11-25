
package client;

import controller.*;
import entity.Player;
import java.util.*;

/**
 *
 * @author Jaylim, ZF
 */
public class RaceDriver {
    

    public static void main(String[] args) { 

       gameStart gameStart = new gameStart();
       Player player = new Player();
       
       Scanner scan = new Scanner(System.in);
       String selection;
        
        System.out.println("\n");
    		System.out.println("1. Register and Start the game");
	    	System.out.println("2. View Ranking");
	    	System.out.println("3. Exit");
	    	System.out.print("Selection: ");
                selection = scan.next();
                
                if(selection.equals("1")){
                    
                    registerMember();
                    gameStart.run(); //haven save time to member, create new column for member time.
	    	}else if(selection.equals("2")){
	    		viewRanking();
	    	}else if(selection.equals("3")){
	    		System.exit(-1);
	    	}else{
	    		System.out.println("Error. Please enter again.");
	    		System.out.println();
                }
                    
       // System.out.println(dice()); to roll dice
    }
    

    private static void registerMember() {
        ctrlMaintainPlayer playerControl = new ctrlMaintainPlayer();
        
        String name;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n-Registration-\nPlayer Name:");
        name = scan.nextLine();
        playerControl.addRecord(name);
        if (playerControl.checkName(name) == true){
            System.out.println("Your name has successfully registered. ");
        }else{
            System.out.println("Oh no, your name cannot be register. Please try again later.");
            System.exit(0);
        }
        
    }


    private static void viewRanking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
